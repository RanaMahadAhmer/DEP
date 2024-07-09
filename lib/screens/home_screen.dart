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
  late List<Map<String, dynamic>> tasks;

  void _update() {
    setState(() {});
  }

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    DatabaseDao.getTasks().then((onValue) {
      setState(() {
        tasks = onValue;
      });
    });
    return Scaffold(
      appBar: AppBar(
        title: shadowedText(txt: "To Do List", size: 25),
      ),
      body: (tasks.isEmpty)
          ? Padding(
              padding: const EdgeInsets.all(8.0),
              child: Column(
                children: [
                  getDivider(),
                  Expanded(
                      child: Center(child: shadowedText(txt: "Add new Tasks"))),
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
                      child: Column(
                        children: [
                          getDivider(),
                          for (final task in tasks)
                            TaskCard(
                              fun: () {
                                Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                    builder: (context) =>
                                        TaskScreen(oldTask: Task.fromMap(task)),
                                  ),
                                ).whenComplete(_update);
                              },
                              task: Task.fromMap(task),
                            ),
                        ],
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
                {
                  "id": null,
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
