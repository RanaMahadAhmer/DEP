import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:to_do_list_app/database/database_dao.dart';
import 'package:to_do_list_app/notifications/local_notifications.dart';
import 'package:to_do_list_app/screens/home_screen.dart';

import 'data_and_design/design.dart';
import 'data_and_design/task.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await LocalNotifications.init();
  await DatabaseDao.init();

  SystemChrome.setPreferredOrientations([
    DeviceOrientation.portraitUp,
  ]);
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'To Do',
      home: HomeScreen(),
    );
  }
}
