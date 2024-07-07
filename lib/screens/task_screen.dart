import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:omni_datetime_picker/omni_datetime_picker.dart';
import 'package:to_do_list_app/screens/home_screen.dart';

import '../data_and_design/data.dart';
import '../data_and_design/design.dart';

class TaskScreen extends StatefulWidget {
  Map oldTask;

  TaskScreen({super.key, required this.oldTask});

  static const String id = "new_task_screen";

  @override
  State<TaskScreen> createState() => _TaskScreenState();
}

class _TaskScreenState extends State<TaskScreen> {
  // String selectedCategory = categories.first;
  late Map newTask = widget.oldTask;

  _createLabel({required String txt}) {
    return Text(
      txt,
      style:
          const TextStyle(fontSize: 20, fontWeight: FontWeight.w500, shadows: [
        Shadow(
          blurRadius: 20,
          color: Colors.black,
          offset: Offset(4, 4),
        )
      ]),
    );
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
        controller: TextEditingController(text: text),
        style: const TextStyle(color: Colors.black87),
        onChanged: fun,
        minLines: long ? 10 : 1,
        maxLines: long ? 10 : 1,
      ),
    );
  }

  no() async {
    DateTime? dateTime = await showOmniDateTimePicker(
      context: context,
      initialDate: DateTime.now(),
      firstDate: DateTime.now(),
      lastDate: DateTime.now().add(
        const Duration(days: 30),
      ),
      is24HourMode: false,
      isShowSeconds: false,
      minutesInterval: 1,
      secondsInterval: 1,
      borderRadius: const BorderRadius.all(Radius.circular(10)),
      constraints: const BoxConstraints(
        maxWidth: 350,
        maxHeight: 650,
      ),
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
      // barrierDismissible: true,
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
            const Text("New Task"),
            IconButton(
              onPressed: () {
                if (tasks.contains(widget.oldTask)) {
                  tasks.remove(widget.oldTask);
                }
                Navigator.pop(context);
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
                    _createLabel(txt: "Title"),
                    _createInputField(
                      text: newTask["title"],
                      fun: (value) {
                        newTask["title"] = value;
                      },
                    ),
                    _createLabel(txt: "Category"),
                    Row(
                      children: [
                        Container(
                          decoration: decoration,
                          margin: const EdgeInsets.symmetric(vertical: 8),
                          child: DropdownMenu<String>(
                            leadingIcon: createCategoryMark(
                                taskCategory: newTask["category"] == ""
                                    ? categories.first
                                    : newTask["category"]),
                            enableSearch: false,
                            initialSelection: newTask["category"] == ""
                                ? categories.first
                                : newTask["category"],
                            onSelected: (String? value) {
                              setState(
                                () {
                                  newTask["category"] = value!;
                                },
                              );
                            },
                            dropdownMenuEntries:
                                categories.map<DropdownMenuEntry<String>>(
                              (String value) {
                                return DropdownMenuEntry<String>(
                                  leadingIcon: createCategoryMark(
                                    taskCategory: value,
                                  ),
                                  value: value,
                                  label: value,
                                );
                              },
                            ).toList(),
                          ),
                        ),
                        IconButton(
                          onPressed: () async {
                            DateTime dateTime = await no();
                            print(dateTime);
                          },
                          icon: const Icon(Icons.abc),
                        ),
                      ],
                    ),
                    _createLabel(txt: "Detail"),
                    _createInputField(
                        text: newTask["detail"],
                        long: true,
                        fun: (value) {
                          newTask["detail"] = value;
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
      floatingActionButtonAnimator: FloatingActionButtonAnimator.scaling,
      floatingActionButton: createButton(
        txt: "Save",
        fun: () {
          if (newTask["title"].isNotEmpty) {
            if (tasks.contains(widget.oldTask)) {
              tasks[tasks.indexOf(widget.oldTask)] = newTask;
            } else {
              tasks.add(
                {
                  "title": newTask["title"],
                  "detail": newTask["detail"],
                  "category": newTask["category"],
                },
              );
            }
            Navigator.pop(context);
          }
        },
      ),
    );
  }
}
