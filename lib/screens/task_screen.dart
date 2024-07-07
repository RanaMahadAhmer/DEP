import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
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

  _createInputField(
      {required String text,
      bool long = false,
      required Function(String) fun}) {
    return Container(
      padding: const EdgeInsets.symmetric(horizontal: 8),
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

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("New Task"),
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
                    const Text(
                      "Title",
                      style:
                          TextStyle(fontSize: 20, fontWeight: FontWeight.w500),
                    ),
                    _createInputField(
                      text: newTask["title"],
                      fun: (value) {
                        newTask["title"] = value;
                      },
                    ),
                    DropdownMenu<String>(
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
                            leadingIcon: Container(
                              height: 8,
                              width: 8,
                              decoration: BoxDecoration(
                                  shape: BoxShape.circle, color: colors[value]),
                            ),
                            value: value,
                            label: value,
                          );
                        },
                      ).toList(),
                    ),
                    const Text(
                      "Detail",
                      style:
                          TextStyle(fontSize: 20, fontWeight: FontWeight.w500),
                    ),
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
      floatingActionButton: createButton(
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
