import 'package:flutter/foundation.dart';
import 'package:sqflite/sqflite.dart';

import '../data_and_design/task.dart';

class DatabaseDao {
  static Database? database;

  static Future<void> init() async {
    var databasesPath = await getDatabasesPath();
    late String path = '${databasesPath}todo.db';

    database = await openDatabase(path, version: 1,
        onCreate: (Database db, int version) async {
      if (kDebugMode) {
        print("Database Connected");
      }
      await db.execute(
          'CREATE TABLE IF NOT EXISTS Tasks(id INTEGER PRIMARY KEY, title TEXT, detail TEXT, category TEXT, reminder TEXT)');
    });
  }

  static Future<void> insertTask(Task task) async {
    await database!.transaction((txn) async {
      await txn.rawInsert(
          'INSERT INTO Tasks(title, detail, category, reminder) VALUES("${task.title}", "${task.detail}", "${task.category}", "${task.reminder}")');
    });
  }

  static Future<List<Map<String, dynamic>>> getTasks() async {
    return await database!.rawQuery('SELECT * FROM Tasks');
  }

  static Future<void> deleteTask(int id) async {
    await database!.transaction((txn) async {
      await txn.rawInsert('DELETE FROM Tasks WHERE id=$id');
    });
  }

  static Future<void> updateTask(Task task) async {
    await database!.transaction((txn) async {
      await txn.rawInsert(
          'UPDATE Tasks SET title="${task.title}", detail="${task.detail}", category="${task.category}", reminder="${task.reminder}" WHERE id=${task.id}');
    });
  }
}
