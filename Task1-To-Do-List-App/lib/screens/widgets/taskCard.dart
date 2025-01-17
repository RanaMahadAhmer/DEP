import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

import '../../data_and_design/design.dart';
import '../../data_and_design/task.dart';

//TODO: Check if reminder is not null and if the notification has passed.

class TaskCard extends StatefulWidget {
  Task task;

  VoidCallback fun;

  TaskCard({super.key, required this.task, required this.fun});

  @override
  State<TaskCard> createState() => _TaskCardState();
}

class _TaskCardState extends State<TaskCard> {
  _getTimeStatus() {
    if (widget.task.reminder == "null") {
      return "No Reminder";
    }
    switch (DateTime.now().compareTo(DateTime.parse(widget.task.reminder))) {
      case -1:
        return widget.task.reminder.split('.')[0];
      case 0:
        return "Reminder Due Now";
      case 1:
        return "Reminder Expired";
    }
  }

  @override
  Widget build(BuildContext context) {
    String status = _getTimeStatus();
    return Padding(
        padding: const EdgeInsets.symmetric(vertical: 8.0),
        child: GestureDetector(
          onTap: widget.fun,
          child: Container(
              padding: const EdgeInsets.all(5),
              decoration: decoration,
              child: Column(
                children: [
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Flexible(
                        child: Text(
                          widget.task.title,
                          overflow: TextOverflow.ellipsis,
                          style: const TextStyle(
                              fontSize: 18, fontWeight: FontWeight.bold),
                        ),
                      ),
                      Row(
                        children: [
                          Text(
                            widget.task.category,
                            style: const TextStyle(
                                fontSize: 15, fontWeight: FontWeight.w600),
                          ),
                          Padding(
                            padding: const EdgeInsets.symmetric(horizontal: 5),
                            child: createCategoryMark(
                                taskCategory: widget.task.category),
                          ),
                        ],
                      ),
                    ],
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Flexible(
                        child: Text(
                          widget.task.detail,
                          softWrap: false,
                          overflow: TextOverflow.ellipsis,
                          style: const TextStyle(fontSize: 15),
                        ),
                      ),
                      Padding(
                        padding: const EdgeInsets.symmetric(horizontal: 10.0),
                        child: Text(
                          status,
                          style: TextStyle(
                              fontSize: 15,
                              color: (status == "Reminder Expired" ||
                                      status == "Reminder Due Now")
                                  ? Colors.red
                                  : Colors.black),
                        ),
                      ),
                    ],
                  ),
                ],
              )),
        ));
  }
}
