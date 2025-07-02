package ui;

import java.util.Scanner;
import service.CourseService;
import service.TeacherService;
import service.ClassroomService;
import service.ScheduleService;
import model.Course;
import model.Teacher;
import model.Classroom;
import model.Schedule;

public class MainMenu {
    private Scanner scanner = new Scanner(System.in);
    private CourseService courseService = new CourseService();
    private TeacherService teacherService = new TeacherService();
    private ClassroomService classroomService = new ClassroomService();
    private ScheduleService scheduleService = new ScheduleService();
    
    public void showMenu() {
        while (true) {
            System.out.println("\n===== 排课系统主菜单 =====");
            System.out.println("1. 课程管理");
            System.out.println("2. 教师管理");
            System.out.println("3. 教室管理");
            System.out.println("4. 排课管理");
            System.out.println("0. 退出系统");
            System.out.print("请选择: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符
            
            switch (choice) {
                case 1:
                    courseManagement();
                    break;
                case 2:
                    teacherManagement();
                    break;
                case 3:
                    classroomManagement();
                    break;
                case 4:
                    scheduleManagement();
                    break;
                case 0:
                    System.out.println("感谢使用排课系统，再见！");
                    return;
                default:
                    System.out.println("无效选择，请重新输入！");
            }
        }
    }
    
    private void courseManagement() {
        while (true) {
            System.out.println("\n===== 课程管理 =====");
            System.out.println("1. 添加课程");
            System.out.println("2. 删除课程");
            System.out.println("3. 修改课程");
            System.out.println("4. 查询所有课程");
            System.out.println("5. 按ID查询课程");
            System.out.println("0. 返回主菜单");
            System.out.print("请选择: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    deleteCourse();
                    break;
                case 3:
                    updateCourse();
                    break;
                case 4:
                    listAllCourses();
                    break;
                case 5:
                    getCourseById();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效选择，请重新输入！");
            }
        }
    }
    
    private void addCourse() {
        System.out.print("输入课程ID: ");
        String courseId = scanner.nextLine();
        System.out.print("输入课程名称: ");
        String courseName = scanner.nextLine();
        System.out.print("输入学分: ");
        int credit = scanner.nextInt();
        System.out.print("输入课时: ");
        int hours = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        
        Course course = new Course(courseId, courseName, credit, hours);
        if (courseService.addCourse(course)) {
            System.out.println("课程添加成功！");
        } else {
            System.out.println("课程添加失败，可能ID已存在！");
        }
    }
    
    private void deleteCourse() {
        System.out.print("输入要删除的课程ID: ");
        String courseId = scanner.nextLine();
        
        if (courseService.deleteCourse(courseId)) {
            System.out.println("课程删除成功！");
        } else {
            System.out.println("课程删除失败，可能ID不存在！");
        }
    }
    
    private void updateCourse() {
        System.out.print("输入要修改的课程ID: ");
        String courseId = scanner.nextLine();
        Course course = courseService.getCourseById(courseId);
        
        if (course == null) {
            System.out.println("课程不存在！");
            return;
        }
        
        System.out.print("输入新课程名称(" + course.getCourseName() + "): ");
        String courseName = scanner.nextLine();
        System.out.print("输入新学分(" + course.getCredit() + "): ");
        int credit = scanner.nextInt();
        System.out.print("输入新课时(" + course.getHours() + "): ");
        int hours = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        
        course.setCourseName(courseName);
        course.setCredit(credit);
        course.setHours(hours);
        
        if (courseService.updateCourse(course)) {
            System.out.println("课程修改成功！");
        } else {
            System.out.println("课程修改失败！");
        }
    }
    
    private void listAllCourses() {
        System.out.println("\n===== 所有课程列表 =====");
        courseService.getAllCourses().forEach(System.out::println);
    }
    
    private void getCourseById() {
        System.out.print("输入要查询的课程ID: ");
        String courseId = scanner.nextLine();
        Course course = courseService.getCourseById(courseId);
        
        if (course != null) {
            System.out.println(course);
        } else {
            System.out.println("课程不存在！");
        }
    }
    
    // 教师管理相关方法 (类似课程管理)
    private void teacherManagement() {
        while (true) {
            System.out.println("\n===== 教师管理 =====");
            System.out.println("1. 添加教师");
            System.out.println("2. 删除教师");
            System.out.println("3. 修改教师");
            System.out.println("4. 查询所有教师");
            System.out.println("5. 按ID查询教师");
            System.out.println("0. 返回主菜单");
            System.out.print("请选择: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    deleteTeacher();
                    break;
                case 3:
                    updateTeacher();
                    break;
                case 4:
                    listAllTeachers();
                    break;
                case 5:
                    getTeacherById();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效选择，请重新输入！");
            }
        }
    }
    
    private void addTeacher() {
        System.out.print("输入教师ID: ");
        String teacherId = scanner.nextLine();
        System.out.print("输入教师姓名: ");
        String name = scanner.nextLine();
        System.out.print("输入职称: ");
        String title = scanner.nextLine();
        System.out.print("输入所属院系: ");
        String department = scanner.nextLine();
        
        Teacher teacher = new Teacher(teacherId, name, title, department);
        if (teacherService.addTeacher(teacher)) {
            System.out.println("教师添加成功！");
        } else {
            System.out.println("教师添加失败，可能ID已存在！");
        }
    }
    
    private void deleteTeacher() {
        System.out.print("输入要删除的教师ID: ");
        String teacherId = scanner.nextLine();
        
        if (teacherService.deleteTeacher(teacherId)) {
            System.out.println("教师删除成功！");
        } else {
            System.out.println("教师删除失败，可能ID不存在！");
        }
    }
    
    private void updateTeacher() {
        System.out.print("输入要修改的教师ID: ");
        String teacherId = scanner.nextLine();
        Teacher teacher = teacherService.getTeacherById(teacherId);
        
        if (teacher == null) {
            System.out.println("教师不存在！");
            return;
        }
        
        System.out.print("输入新姓名(" + teacher.getName() + "): ");
        String name = scanner.nextLine();
        System.out.print("输入新职称(" + teacher.getTitle() + "): ");
        String title = scanner.nextLine();
        System.out.print("输入新院系(" + teacher.getDepartment() + "): ");
        String department = scanner.nextLine();
        
        teacher.setName(name);
        teacher.setTitle(title);
        teacher.setDepartment(department);
        
        if (teacherService.updateTeacher(teacher)) {
            System.out.println("教师修改成功！");
        } else {
            System.out.println("教师修改失败！");
        }
    }
    
    private void listAllTeachers() {
        System.out.println("\n===== 所有教师列表 =====");
        teacherService.getAllTeachers().forEach(System.out::println);
    }
    
    private void getTeacherById() {
        System.out.print("输入要查询的教师ID: ");
        String teacherId = scanner.nextLine();
        Teacher teacher = teacherService.getTeacherById(teacherId);
        
        if (teacher != null) {
            System.out.println(teacher);
        } else {
            System.out.println("教师不存在！");
        }
    }
    
    // 教室管理相关方法 (类似课程管理)
    private void classroomManagement() {
        while (true) {
            System.out.println("\n===== 教室管理 =====");
            System.out.println("1. 添加教室");
            System.out.println("2. 删除教室");
            System.out.println("3. 修改教室");
            System.out.println("4. 查询所有教室");
            System.out.println("5. 按ID查询教室");
            System.out.println("0. 返回主菜单");
            System.out.print("请选择: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addClassroom();
                    break;
                case 2:
                    deleteClassroom();
                    break;
                case 3:
                    updateClassroom();
                    break;
                case 4:
                    listAllClassrooms();
                    break;
                case 5:
                    getClassroomById();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效选择，请重新输入！");
            }
        }
    }
    
    private void addClassroom() {
        System.out.print("输入教室ID: ");
        String roomId = scanner.nextLine();
        System.out.print("输入所在楼栋: ");
        String building = scanner.nextLine();
        System.out.print("输入容量: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        System.out.print("输入教室类型: ");
        String type = scanner.nextLine();
        
        Classroom classroom = new Classroom(roomId, building, capacity, type);
        if (classroomService.addClassroom(classroom)) {
            System.out.println("教室添加成功！");
        } else {
            System.out.println("教室添加失败，可能ID已存在！");
        }
    }
    
    private void deleteClassroom() {
        System.out.print("输入要删除的教室ID: ");
        String roomId = scanner.nextLine();
        
        if (classroomService.deleteClassroom(roomId)) {
            System.out.println("教室删除成功！");
        } else {
            System.out.println("教室删除失败，可能ID不存在！");
        }
    }
    
    private void updateClassroom() {
        System.out.print("输入要修改的教室ID: ");
        String roomId = scanner.nextLine();
        Classroom classroom = classroomService.getClassroomById(roomId);
        
        if (classroom == null) {
            System.out.println("教室不存在！");
            return;
        }
        
        System.out.print("输入新楼栋(" + classroom.getBuilding() + "): ");
        String building = scanner.nextLine();
        System.out.print("输入新容量(" + classroom.getCapacity() + "): ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        System.out.print("输入新类型(" + classroom.getType() + "): ");
        String type = scanner.nextLine();
        
        classroom.setBuilding(building);
        classroom.setCapacity(capacity);
        classroom.setType(type);
        
        if (classroomService.updateClassroom(classroom)) {
            System.out.println("教室修改成功！");
        } else {
            System.out.println("教室修改失败！");
        }
    }
    
    private void listAllClassrooms() {
        System.out.println("\n===== 所有教室列表 =====");
        classroomService.getAllClassrooms().forEach(System.out::println);
    }
    
    private void getClassroomById() {
        System.out.print("输入要查询的教室ID: ");
        String roomId = scanner.nextLine();
        Classroom classroom = classroomService.getClassroomById(roomId);
        
        if (classroom != null) {
            System.out.println(classroom);
        } else {
            System.out.println("教室不存在！");
        }
    }
    
    // 排课管理
    private void scheduleManagement() {
        while (true) {
            System.out.println("\n===== 排课管理 =====");
            System.out.println("1. 添加排课");
            System.out.println("2. 删除排课");
            System.out.println("3. 修改排课");
            System.out.println("4. 查询所有排课");
            System.out.println("5. 按ID查询排课");
            System.out.println("6. 条件查询排课");
            System.out.println("0. 返回主菜单");
            System.out.print("请选择: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addSchedule();
                    break;
                case 2:
                    deleteSchedule();
                    break;
                case 3:
                    updateSchedule();
                    break;
                case 4:
                    listAllSchedules();
                    break;
                case 5:
                    getScheduleById();
                    break;
                case 6:
                    findSchedules();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("无效选择，请重新输入！");
            }
        }
    }
    
    private void addSchedule() {
        // 显示可选课程
        System.out.println("\n可选课程:");
        courseService.getAllCourses().forEach(System.out::println);
        System.out.print("输入课程ID: ");
        String courseId = scanner.nextLine();
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            System.out.println("课程不存在！");
            return;
        }
        
        // 显示可选教师
        System.out.println("\n可选教师:");
        teacherService.getAllTeachers().forEach(System.out::println);
        System.out.print("输入教师ID: ");
        String teacherId = scanner.nextLine();
        Teacher teacher = teacherService.getTeacherById(teacherId);
        if (teacher == null) {
            System.out.println("教师不存在！");
            return;
        }
        
        // 显示可选教室
        System.out.println("\n可选教室:");
        classroomService.getAllClassrooms().forEach(System.out::println);
        System.out.print("输入教室ID: ");
        String roomId = scanner.nextLine();
        Classroom classroom = classroomService.getClassroomById(roomId);
        if (classroom == null) {
            System.out.println("教室不存在！");
            return;
        }
        
        System.out.print("输入时间(如: 周一1-2节): ");
        String time = scanner.nextLine();
        System.out.print("输入开始周次: ");
        int weekStart = scanner.nextInt();
        System.out.print("输入结束周次: ");
        int weekEnd = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符
        
        // 生成排课ID (简单实现)
        String scheduleId = "SC" + System.currentTimeMillis();
        
        Schedule schedule = new Schedule(scheduleId, course, teacher, classroom, time, weekStart, weekEnd);
        if (scheduleService.addSchedule(schedule)) {
            System.out.println("排课添加成功！");
        } else {
            System.out.println("排课添加失败，可能存在冲突！");
        }
    }
    
    private void deleteSchedule() {
        System.out.print("输入要删除的排课ID: ");
        String scheduleId = scanner.nextLine();
        
        if (scheduleService.deleteSchedule(scheduleId)) {
            System.out.println("排课删除成功！");
        } else {
            System.out.println("排课删除失败，可能ID不存在！");
        }
    }
    
    private void updateSchedule() {
        System.out.print("输入要修改的排课ID: ");
        String scheduleId = scanner.nextLine();
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
        
        if (schedule == null) {
            System.out.println("排课不存在！");
            return;
        }
        
        System.out.println("当前排课信息: " + schedule);
        
        // 显示可选课程
        System.out.println("\n可选课程:");
        courseService.getAllCourses().forEach(System.out::println);
        System.out.print("输入新课程ID(" + schedule.getCourse().getCourseId() + "): ");
        String courseId = scanner.nextLine();
        if (!courseId.isEmpty()) {
            Course course = courseService.getCourseById(courseId);
            if (course != null) {
                schedule.setCourse(course);
            }
        }
        
        // 显示可选教师
        System.out.println("\n可选教师:");
        teacherService.getAllTeachers().forEach(System.out::println);
        System.out.print("输入新教师ID(" + schedule.getTeacher().getTeacherId() + "): ");
        String teacherId = scanner.nextLine();
        if (!teacherId.isEmpty()) {
            Teacher teacher = teacherService.getTeacherById(teacherId);
            if (teacher != null) {
                schedule.setTeacher(teacher);
            }
        }
        
        // 显示可选教室
        System.out.println("\n可选教室:");
        classroomService.getAllClassrooms().forEach(System.out::println);
        System.out.print("输入新教室ID(" + schedule.getClassroom().getRoomId() + "): ");
        String roomId = scanner.nextLine();
        if (!roomId.isEmpty()) {
            Classroom classroom = classroomService.getClassroomById(roomId);
            if (classroom != null) {
                schedule.setClassroom(classroom);
            }
        }
        
        System.out.print("输入新时间(" + schedule.getTime() + "): ");
        String time = scanner.nextLine();
        if (!time.isEmpty()) {
            schedule.setTime(time);
        }
        
        System.out.print("输入新开始周次(" + schedule.getWeekStart() + "): ");
        String weekStartStr = scanner.nextLine();
        if (!weekStartStr.isEmpty()) {
            schedule.setWeekStart(Integer.parseInt(weekStartStr));
        }
        
        System.out.print("输入新结束周次(" + schedule.getWeekEnd() + "): ");
        String weekEndStr = scanner.nextLine();
        if (!weekEndStr.isEmpty()) {
            schedule.setWeekEnd(Integer.parseInt(weekEndStr));
        }
        
        if (scheduleService.updateSchedule(schedule)) {
            System.out.println("排课修改成功！");
        } else {
            System.out.println("排课修改失败，可能存在冲突！");
        }
    }
    
    private void listAllSchedules() {
        System.out.println("\n===== 所有排课列表 =====");
        scheduleService.getAllSchedules().forEach(System.out::println);
    }
    
    private void getScheduleById() {
        System.out.print("输入要查询的排课ID: ");
        String scheduleId = scanner.nextLine();
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
        
        if (schedule != null) {
            System.out.println(schedule);
        } else {
            System.out.println("排课不存在！");
        }
    }
    
    private void findSchedules() {
        System.out.print("输入课程ID(留空忽略): ");
        String courseId = scanner.nextLine();
        System.out.print("输入教师ID(留空忽略): ");
        String teacherId = scanner.nextLine();
        System.out.print("输入教室ID(留空忽略): ");
        String roomId = scanner.nextLine();
        
        List<Schedule> result = scheduleService.findSchedules(
            courseId.isEmpty() ? null : courseId,
            teacherId.isEmpty() ? null : teacherId,
            roomId.isEmpty() ? null : roomId
        );
        
        System.out.println("\n===== 查询结果 =====");
        if (result.isEmpty()) {
            System.out.println("没有找到匹配的排课！");
        } else {
            result.forEach(System.out::println);
        }
    }
}
