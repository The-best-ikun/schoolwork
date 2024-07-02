-- 插入学院数据
INSERT INTO Colleges (college_name) VALUES ('计算机学院');
INSERT INTO Colleges (college_name) VALUES ('经济学院');
INSERT INTO Colleges (college_name) VALUES ('法学院');

-- 插入专业数据
INSERT INTO Majors (major_name, college_id) VALUES ('计算机科学与技术', 1);
INSERT INTO Majors (major_name, college_id) VALUES ('软件工程', 1);
INSERT INTO Majors (major_name, college_id) VALUES ('经济学', 2);
INSERT INTO Majors (major_name, college_id) VALUES ('法学', 3);

-- 插入班级数据
INSERT INTO Classes (class_name, major_id) VALUES ('计算机科学与技术1班', 1);
INSERT INTO Classes (class_name, major_id) VALUES ('计算机科学与技术2班', 1);
INSERT INTO Classes (class_name, major_id) VALUES ('软件工程1班', 2);
INSERT INTO Classes (class_name, major_id) VALUES ('经济学1班', 3);
INSERT INTO Classes (class_name, major_id) VALUES ('法学1班', 4);

-- 插入学生数据
INSERT INTO Students (NAME, gender, age, origin, college_id, major_id, class_id) VALUES ('张三', '男', 20, '北京', 1, 1, 1);
INSERT INTO Students (NAME, gender, age, origin, college_id, major_id, class_id) VALUES ('李四', '女', 19, '上海', 1, 1, 1);
INSERT INTO Students (NAME, gender, age, origin, college_id, major_id, class_id) VALUES ('王五', '男', 20, '广州', 1, 2, 3);
INSERT INTO Students (NAME, gender, age, origin, college_id, major_id, class_id) VALUES ('赵六', '女', 21, '深圳', 2, 3, 4);

-- 插入课程数据
INSERT INTO Courses (course_name, course_type, TIME, location, credits) VALUES ('数据结构', '专业必修课', '周一上午', '教1-101', 4.0);
INSERT INTO Courses (course_name, course_type, TIME, location, credits) VALUES ('计算机网络', '专业必修课', '周二上午', '教1-102', 4.0);
INSERT INTO Courses (course_name, course_type, TIME, location, credits) VALUES ('宏观经济学', '专业必修课', '周三上午', '教2-201', 3.0);
INSERT INTO Courses (course_name, course_type, TIME, location, credits) VALUES ('民法', '专业必修课', '周四上午', '教2-202', 4.0);

-- 插入教师数据
INSERT INTO Teachers (NAME, gender, age, contact_info, origin, title, college_id) VALUES ('王教授', '男', 50, 'wangprofessor@example.com', '北京', '教授', 1);
INSERT INTO Teachers (NAME, gender, age, contact_info, origin, title, college_id) VALUES ('李教授', '女', 45, 'liprofessor@example.com', '上海', '教授', 2);
INSERT INTO Teachers (NAME, gender, age, contact_info, origin, title, college_id) VALUES ('张教授', '男', 55, 'zhangprofessor@example.com', '广州', '教授', 3);

-- 插入选课数据
INSERT INTO Enrollments (student_id, course_id, grade) VALUES (1, 1, 90.0);
INSERT INTO Enrollments (student_id, course_id, grade) VALUES (1, 2, 85.0);
INSERT INTO Enrollments (student_id, course_id, grade) VALUES (2, 1, 92.0);
INSERT INTO Enrollments (student_id, course_id, grade) VALUES (2, 2, 88.0);

-- 插入授课数据
INSERT INTO Teaches (teacher_id, course_id) VALUES (1, 1);
INSERT INTO Teaches (teacher_id, course_id) VALUES (1, 2);
INSERT INTO Teaches (teacher_id, course_id) VALUES (2, 3);
INSERT INTO Teaches (teacher_id, course_id) VALUES (3, 4);

-- 插入用户数据
INSERT INTO Users (username, PASSWORD, email) VALUES ('zhangsan', 'zhangsan123', 'zhangsan@example.com');
INSERT INTO Users (username, PASSWORD, email) VALUES ('lisi', 'lisi123', 'lisi@example.com');