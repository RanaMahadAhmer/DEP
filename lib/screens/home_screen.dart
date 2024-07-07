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

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("To Do List"),
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.only(left: 8.0, right: 8.0, bottom: 8.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              for (final task in tasks)
                Task(
                  task: task,
                  fun: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => TaskScreen(oldTask: task),
                      ),
                    ).whenComplete(_update);
                  },
                ),
            ],
          ),
        ),
      ),
      floatingActionButton: createButton(fun: () {
        Navigator.push(
          context,
          MaterialPageRoute(
              builder: (context) => TaskScreen(
                  oldTask: {"title": "", "detail": "", "category": ""})),
        ).whenComplete(_update);
      }),
    );
  }
}
