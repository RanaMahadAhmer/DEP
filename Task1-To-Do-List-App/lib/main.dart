import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'database/database_dao.dart';
import 'notifications/local_notifications.dart';
import 'screens/home_screen.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await LocalNotifications.init();
  await DatabaseDao.init();

  DateTime n = DateTime.now();
  print(n);

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
