import 'package:flutter/material.dart';
import 'package:flutter_local_notifications/flutter_local_notifications.dart';
import 'package:timezone/data/latest_all.dart' as tz;
import 'package:timezone/timezone.dart' as tz;

class LocalNotifications {
  static const NotificationDetails _notificationDetails = NotificationDetails(
    android: AndroidNotificationDetails("..", 'Todo-Notifications',
        channelDescription:
            'Notifications channel for receiving reminder notification of todo tasks.',
        importance: Importance.max,
        priority: Priority.high,
        ticker: 'ticker'),
  );

  static final FlutterLocalNotificationsPlugin
      _flutterLocalNotificationsPlugin = FlutterLocalNotificationsPlugin();

  static Future<void> init() async {
    tz.initializeTimeZones();
    const settings = InitializationSettings(
        android: AndroidInitializationSettings('@mipmap/ic_launcher'));

    _flutterLocalNotificationsPlugin
        .resolvePlatformSpecificImplementation<
            AndroidFlutterLocalNotificationsPlugin>()
        ?.requestNotificationsPermission();
    await _flutterLocalNotificationsPlugin.initialize(settings,
        onDidReceiveNotificationResponse: (value) {});
  }

  static Future simpleNotification(
      {required int id,
      required String title,
      required String body,
      required String payload}) async {
    await _flutterLocalNotificationsPlugin
        .show(id, title, body, _notificationDetails, payload: payload);
  }

  static Future scheduledNotification(
      {required int id,
      required String title,
      required String body,
      required String payload,
      required Duration duration}) async {
    await _flutterLocalNotificationsPlugin.zonedSchedule(id, title, body,
        tz.TZDateTime.now(tz.local).add(duration), _notificationDetails,
        androidScheduleMode: AndroidScheduleMode.exactAllowWhileIdle,
        uiLocalNotificationDateInterpretation:
            UILocalNotificationDateInterpretation.absoluteTime);
  }

  static Future deleteNotification({required int id}) async {
    await _flutterLocalNotificationsPlugin.cancel(id);
  }
}
