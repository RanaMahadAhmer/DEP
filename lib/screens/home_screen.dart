import 'package:flutter/material.dart';
import 'package:to_do_list_app/screens/task_screen.dart';
import 'package:to_do_list_app/screens/widgets/taskCard.dart';

import '../data_and_design/data.dart';
import '../data_and_design/design.dart';
import '../data_and_design/task.dart';
import '../database/database_dao.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  void _update() {
    setState(() {});
  }

  _getTasks() async {
    return await DatabaseDao.getTasks();
  }

  @override
  Widget build(BuildContext context) {
    var tasks = _getTasks();

    return Scaffold(
      appBar: AppBar(
        title: shadowedText(txt: "To Do List", size: 25),
      ),
      body: (tasks.isEmpty)
          ? Expanded(
              child: Column(
                children: [
                  getDivider(),
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
                            getDivider(),
                            for (final task in tasks)
                              TaskCard(
                                task: Task.fromMap(id: task.id, task: task),
                                fun: () {
                                  Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                      builder: (context) => TaskScreen(
                                          oldTask: Task.fromMap(
                                              id: task.id, task: task)),
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
            builder: (context) => TaskScreen(
              oldTask: Task.fromMap(
                id: null,
                task: {
                  "title": "",
                  "detail": "",
                  "category": "Learning",
                  "reminder": "null"
                },
              ),
            ),
          ),
        ).whenComplete(_update);
      }),
    );
  }
}
