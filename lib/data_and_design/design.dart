import 'dart:ui';

import 'package:flutter/material.dart';

import 'data.dart';

var decoration = BoxDecoration(
  color: const Color.fromARGB(255, 252, 245, 253),
  border: Border.all(color: Colors.black, width: 0.2),
  borderRadius: const BorderRadius.all(Radius.circular(8)),
  boxShadow: const [
    BoxShadow(
        spreadRadius: 1,
        color: Colors.black54,
        offset: Offset(8, 8),
        blurRadius: 5),
  ],
);

FloatingActionButton createButton({String? txt, required VoidCallback fun}) {
  return FloatingActionButton(
    backgroundColor: Colors.black12,
    foregroundColor: Colors.black,
    hoverElevation: 10,
    onPressed: fun,
    child: (txt != null) ? Text(txt) : const Icon(Icons.add),
  );
}

Icon createCategoryMark({required String taskCategory}) {
  return Icon(
    size: 20,
    Icons.bookmark,
    color: colors[taskCategory],
  );
}
