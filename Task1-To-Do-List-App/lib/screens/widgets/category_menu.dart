import 'package:flutter/material.dart';

import '../../data_and_design/data.dart';
import '../../data_and_design/design.dart';
import '../../data_and_design/task.dart';

class CategoryMenu extends StatefulWidget {
  Task task;
  Function(String?) fun;

  CategoryMenu({super.key, required this.task, required this.fun});

  @override
  State<CategoryMenu> createState() => _CategoryMenuState();
}

class _CategoryMenuState extends State<CategoryMenu> {
  @override
  Widget build(BuildContext context) {
    return DropdownMenu<String>(
      textStyle: const TextStyle(fontWeight: FontWeight.w400, fontSize: 18),
      inputDecorationTheme: InputDecorationTheme(
          enabledBorder: disabledInternalBorder,
          activeIndicatorBorder: null,
          focusedBorder: disabledInternalBorder),
      leadingIcon: createCategoryMark(
          taskCategory: widget.task.category == ""
              ? categories.first
              : widget.task.category),
      enableSearch: false,
      initialSelection:
          widget.task.category == "" ? categories.first : widget.task.category,
      onSelected: widget.fun,
      dropdownMenuEntries: categories.map<DropdownMenuEntry<String>>(
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
    );
  }
}
