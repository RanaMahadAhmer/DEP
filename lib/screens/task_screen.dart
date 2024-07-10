import 'package:flutter/cupertino.dart';

import 'package:flutter/material.dart';
import 'package:flutter/painting.dart';
import 'package:flutter/rendering.dart';
import 'package:omni_datetime_picker/omni_datetime_picker.dart';
import '/database/database_dao.dart';

import 'widgets/category_menu.dart';

import '../data_and_design/design.dart';
import '../data_and_design/task.dart';
import '../notifications/local_notifications.dart';

class TaskScreen extends StatefulWidget {
  Task oldTask;

  TaskScreen({super.key, required this.oldTask});

  static const String id = "new_task_screen";

  @override
  State<TaskScreen> createState() => _TaskScreenState();
}

class _TaskScreenState extends State<TaskScreen> {
  late Task _newTask;
  DateTime? _reminder;

  @override
  void initState() {
    super.initState();
    _newTask = widget.oldTask.copy();
  }

  _createInputField(
      {required String text,
      bool long = false,
      required Function(String) fun}) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 8),
      margin: const EdgeInsets.symmetric(vertical: 8),
      decoration: decoration,
      child: TextField(
        decoration: InputDecoration(
          enabledBorder: disabledInternalBorder,
          focusedBorder: disabledInternalBorder,
        ),
        controller: TextEditingController(text: text),
        style: const TextStyle(color: Colors.black87),
        onChanged: fun,
        minLines: long ? 10 : 1,
        maxLines: long ? 10 : 1,
      ),
    );
  }

  getReminder() async {
    DateTime? dateTime = await showOmniDateTimePicker(
      context: context,
      theme: ThemeData(
          buttonTheme: const ButtonThemeData(
              buttonColor: Colors.black12, textTheme: ButtonTextTheme.primary)),
      initialDate: DateTime.now().add(const Duration(minutes: 5)),
      firstDate: DateTime.now().add(const Duration(minutes: 5)),
      lastDate: DateTime.now().add(
        const Duration(days: 30),
      ),
      is24HourMode: false,
      isShowSeconds: true,
      minutesInterval: 1,
      secondsInterval: 1,
      borderRadius: const BorderRadius.all(Radius.circular(10)),
      transitionBuilder: (context, anim1, anim2, child) {
        return FadeTransition(
          opacity: anim1.drive(
            Tween(
              begin: 0,
              end: 1,
            ),
          ),
          child: child,
        );
      },
      transitionDuration: const Duration(milliseconds: 200),
    );

    return dateTime;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            shadowedText(txt: "New Task", size: 22, weight: FontWeight.w600),
            IconButton(
              onPressed: () async {
                if (_newTask.title.isNotEmpty || _newTask.detail.isNotEmpty) {
                  if (widget.oldTask.id != null) {
                    LocalNotifications.deleteNotification(
                        id: widget.oldTask.id!);
                    await DatabaseDao.deleteTask(widget.oldTask.id!);
                  }
                  Navigator.pop(context);
                }
              },
              icon: const Icon(
                Icons.delete_forever_outlined,
                color: Colors.black54,
              ),
              iconSize: 30,
            ),
          ],
        ),
      ),
      body: LayoutBuilder(
        builder: (BuildContext context, BoxConstraints constraints) {
          return SingleChildScrollView(
            child: ConstrainedBox(
              constraints: BoxConstraints(minHeight: constraints.maxHeight),
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  mainAxisAlignment: MainAxisAlignment.start,
                  children: [
                    getDivider(),
                    shadowedText(txt: "Title"),
                    _createInputField(
                      text: _newTask.title,
                      fun: (value) {
                        _newTask.title = value;
                      },
                    ),
                    Row(
                      children: [
                        Expanded(
                            flex: 12, child: shadowedText(txt: "Category")),
                        const Expanded(
                            child: ColoredBox(color: Colors.transparent)),
                        Expanded(
                            flex: 12, child: shadowedText(txt: "Reminder")),
                      ],
                    ),
                    IntrinsicHeight(
                      child: Padding(
                        padding: const EdgeInsets.symmetric(vertical: 8.0),
                        child: Row(
                          crossAxisAlignment: CrossAxisAlignment.stretch,
                          children: [
                            Expanded(
                              flex: 12,
                              child: Container(
                                decoration: decoration,
                                child: FittedBox(
                                  child: CategoryMenu(
                                    task: _newTask,
                                    fun: (String? value) {
                                      setState(
                                        () {
                                          _newTask.category = value!;
                                        },
                                      );
                                    },
                                  ),
                                ),
                              ),
                            ),
                            const Expanded(
                                child: ColoredBox(color: Colors.transparent)),
                            Expanded(
                              flex: 12,
                              child: Container(
                                decoration: decoration,
                                child: TextButton(
                                  onPressed: () async {
                                    _reminder = await getReminder();
                                    if (_reminder != null) {
                                      setState(() {
                                        _newTask.reminder =
                                            _reminder.toString();
                                      });
                                    }
                                  },
                                  child: Text(
                                      (_newTask.reminder == "null")
                                          ? "Set Reminder"
                                          : _newTask.reminder.split('.')[0],
                                      style: const TextStyle(
                                          color: Colors.black,
                                          fontWeight: FontWeight.w400,
                                          fontSize: 13)),
                                ),
                              ),
                            ),
                          ],
                        ),
                      ),
                    ),
                    shadowedText(txt: "Detail"),
                    _createInputField(
                        text: _newTask.detail,
                        long: true,
                        fun: (value) {
                          _newTask.detail = value;
                        }),
                    const SizedBox(
                      height: 10,
                    )
                  ],
                ),
              ),
            ),
          );
        },
      ),
      floatingActionButton: createButton(
        txt: "Save",
        fun: () {
          if (_newTask.title.isNotEmpty) {
            if (widget.oldTask.id != null) {
              DatabaseDao.updateTask(_newTask);
              if (widget.oldTask.reminder != _newTask.reminder) {
                LocalNotifications.deleteNotification(id: _newTask.id!);
                LocalNotifications.scheduledNotification(
                  id: _newTask.id!,
                  title: _newTask.title,
                  body: _newTask.detail,
                  payload: "payload",
                  duration: _reminder!.difference(DateTime.now()),
                );
              }
            } else {
              DatabaseDao.insertTask(_newTask);

              if (_newTask.reminder != "null") {
                int? id;
                DatabaseDao.getNextId().then((onValue) {
                  id = onValue.first.values.first;
                });
                ;
                LocalNotifications.scheduledNotification(
                  id: (id == null) ? 1 : id!,
                  title: _newTask.title,
                  body: _newTask.detail,
                  payload: "payload",
                  duration: _reminder!.difference(DateTime.now()),
                );
              }
            }
            Navigator.pop(context);
          } else {
            ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
                content: Center(child: Text("Add title to task."))));
          }
        },
      ),
    );
  }
}
