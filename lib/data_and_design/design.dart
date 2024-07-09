import 'dart:ui';

import 'package:flutter/material.dart';

import 'data.dart';

var decoration = BoxDecoration(
  color: const Color.fromARGB(255, 252, 245, 253),
  border: Border.all(color: Colors.black, width: 0.4),
  borderRadius: const BorderRadius.all(Radius.circular(8)),
  boxShadow: const [
    BoxShadow(
        spreadRadius: 1,
        color: Colors.black54,
        offset: Offset(8, 8),
        blurRadius: 5),
  ],
);

var disabledInternalBorder = const UnderlineInputBorder(
  borderSide: BorderSide(color: Colors.transparent),
);

shadowedText(
    {required String txt,
    double size = 20,
    FontWeight weight = FontWeight.w500}) {
  return Text(
    txt,
    style: TextStyle(fontSize: size, fontWeight: weight, shadows: const [
      Shadow(
        blurRadius: 40,
        color: Colors.black,
        offset: Offset(0, 5),
      )
    ]),
  );
}

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

getDivider() {
  return const Divider(
    height: 2,
    thickness: 5,
    color: Colors.black54,
  );
}
