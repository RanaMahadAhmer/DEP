import 'package:flutter/material.dart';
import 'package:to_do_list_app/screens/task_screen.dart';
import 'package:to_do_list_app/screens/widgets/task.dart';

import '../data_and_design/data.dart';
import '../data_and_design/design.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  void _update() {
    setState(() {});
  }

  _getDivider() {
    return const Divider(
      height: 2,
      thickness: 5,
      color: Colors.black54,
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: shadowedText(txt: "To Do List", size: 25),
      ),
      body: (tasks.isEmpty)
          ? Expanded(
              child: Column(
                children: [
                  _getDivider(),
                  Expanded(
                    child: Center(
                      child: shadowedText(txt: "Add new Tasks"),
                    ),
                  ),
                ],
              ),
            )
          : LayoutBuilder(
              builder: (BuildContext context, BoxConstraints constraints) {
                return ConstrainedBox(
                  constraints: BoxConstraints(minHeight: constraints.maxHeight),
                  child: SingleChildScrollView(
                    child: Padding(
                      padding: const EdgeInsets.only(
                          left: 8.0, right: 8.0, bottom: 8.0),
                      child: Expanded(
                        child: Column(
                          children: [
                            _getDivider(),
                            for (final task in tasks)
                              Task(
                                task: task,
                                fun: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                      builder: (context) =>
                                          TaskScreen(oldTask: task),
                                    ),
                                  ).whenComplete(_update);
                                },
                              ),
                          ],
                        ),
                      ),
                    ),
                  ),
                );
              },
            ),
      floatingActionButton: createButton(fun: () {
        Navigator.push(
          context,
          MaterialPageRoute(
              builder: (context) => TaskScreen(oldTask: const {
                    "title": "",
                    "detail": "",
                    "category": "Learning",
                    "reminder": "null"
                  })),
        ).whenComplete(_update);
      }),
    );
  }
}
