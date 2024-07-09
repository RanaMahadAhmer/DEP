class Task {
  int? id;
  late String title;
  late String detail;
  late String category;
  late String reminder;

  Task();

  Task.fromMap({int? id, required Map<String, dynamic> task}) {
    id = id;
    title = task["title"];
    detail = task["detail"];
    category = task["category"];
    reminder = task["reminder"];
  }

  copy() {
    return {
      "id": id,
      "title": title,
      "detail": detail,
      "category": category,
      "reminder": reminder
    };
  }

  compare(Task other) {
    return title == other.title && detail == other.detail;
  }

  @override
  String toString() {
    return "Task: {$id $title, $detail, $category, $reminder}";
    return super.toString();
  }
}
