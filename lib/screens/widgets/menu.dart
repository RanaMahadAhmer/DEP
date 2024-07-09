import 'package:flutter/material.dart';

import '../../data_and_design/data.dart';
import '../../data_and_design/design.dart';

class Menu extends StatefulWidget {
  Map task;
  Function(String?) fun;

  Menu({super.key, required this.task, required this.fun});

  @override
  State<Menu> createState() => _MenuState();
}

class _MenuState extends State<Menu> {
  @override
  Widget build(BuildContext context) {
    return DropdownMenu<String>(
      inputDecorationTheme: InputDecorationTheme(
          enabledBorder: disabledInternalBorder,
          activeIndicatorBorder: null,
          focusedBorder: disabledInternalBorder),
      leadingIcon: createCategoryMark(
          taskCategory: widget.task["category"] == ""
              ? categories.first
              : widget.task["category"]),
      enableSearch: false,
      initialSelection: widget.task["category"] == ""
          ? categories.first
          : widget.task["category"],
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
