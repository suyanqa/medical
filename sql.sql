CREATE DATABASE IF NOT EXISTS medical;

USE medical;

-- 医疗信息管理表
CREATE TABLE IF NOT EXISTS medical (
    record_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,          -- 患者ID，与患者基本信息表关联
    admission_date DATE,              -- 入院日期
    discharge_date DATE,             -- 出院日期
    diagnosis VARCHAR(255),           -- 主要诊断
    detailed_diagnosis TEXT,          -- 详细诊断描述
    treatment_plan TEXT,              -- 治疗方案
    medications TEXT,                 -- 使用药物及剂量（可考虑分解为单独的药物使用表）
    allergies VARCHAR(255),           -- 过敏史
    doctor_id INT,                   -- 负责医生ID，与医生表关联
    nurse_notes TEXT,                -- 护士备注
    vital_signs JSON,                 -- 生命体征（如血压、心率等，可使用JSON格式存储）
    lab_results JSON,                 -- 实验室检测结果（多个结果可以JSON数组存储）
    imaging_reports TEXT,            -- 影像报告
    operation_history TEXT,           -- 手术历史
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 记录创建时间
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 记录最后更新时间
);

-- 索引建议
CREATE INDEX idx_patient_id ON medical(patient_id);
CREATE INDEX idx_doctor_id ON medical(doctor_id);
CREATE INDEX idx_admission_date ON medical(admission_date);

-- 医疗信息管理表测试数据
INSERT INTO medical (patient_id, admission_date, discharge_date, diagnosis, detailed_diagnosis, treatment_plan, medications, allergies, doctor_id, nurse_notes, vital_signs, lab_results, imaging_reports, operation_history)
VALUES
    (1, '2024-05-01', '2024-05-05', '肺炎', '患者呼吸急促，胸部X光显示肺部感染', '静脉注射抗生素，休息', '头孢、氧氟沙星', '花粉过敏', 101, '患者需要休息，密切观察病情变化', '{"blood_pressure": "120/80", "heart_rate": "80"}', '{"blood_test": {"WBC": 12000, "Hb": 12.5}, "urine_test": {"WBC": "normal", "protein": "negative"}}', 'CT扫描显示肺部感染', '无手术史'),
    (2, '2024-04-28', '2024-05-03', '心脏病', '患者胸痛，心电图显示心脏异常', '心血管检查，口服药物', '阿司匹林、贝他类药物', '无', 102, '患者情绪不稳定，需关注心理状况', '{"blood_pressure": "140/90", "heart_rate": "100"}', '{"ECG": "ST段改变"}', '心脏彩超显示心脏扩张', '曾有冠心病手术史'),
    (3, '2024-05-03', '2024-05-07', '中风', '患者右侧肢体无力，脑部CT检查发现脑梗塞', '卧床休息，理疗', '阿司匹林、肝素', '无', 103, '患者需定期测量血压，注意饮食', '{"blood_pressure": "150/95", "heart_rate": "85"}', '{"CT_scan": "右侧脑梗塞"}', 'MRI显示脑梗塞位置', '无手术史');


-- 创建医生信息管理表
CREATE TABLE medical.doctors (
                                 id INT AUTO_INCREMENT PRIMARY KEY, -- 医生ID，主键，自增
                                 name VARCHAR(100), -- 医生姓名
                                 age INT, -- 医生年龄
                                 gender VARCHAR(10), -- 医生性别
                                 contact VARCHAR(20), -- 联系方式
                                 address VARCHAR(255), -- 地址
                                 certification VARCHAR(255), -- 证书和执业资格
                                 specialty VARCHAR(255), -- 专业领域
                                 clinical_experience VARCHAR(255), -- 临床经验
                                 schedule VARCHAR(255), -- 工作时间表
                                 leave_schedule VARCHAR(255), -- 休假安排
                                 communication_records TEXT, -- 与患者之间的沟通记录
                                 medical_records TEXT -- 医疗记录
);

-- 添加医生信息测试数据
INSERT INTO medical.doctors (name, age, gender, contact, address, certification, specialty, clinical_experience, schedule, leave_schedule, communication_records, medical_records) VALUES
    ('张医生', 35, '男', '1234567890', '北京市朝阳区', '心脏病学资格证', '心脏病学', '5年', '周一至周五上午9点至下午5点', '每周周末休息', '电话：1234567890，电子邮件：zhang@example.com，在线咨询：https://example.com/zhang', '诊断结果：高血压，治疗方案：药物治疗');
INSERT INTO medical.doctors (name, age, gender, contact, address, certification, specialty, clinical_experience, schedule, leave_schedule, communication_records, medical_records) VALUES
    ('李医生', 40, '女', '0987654321', '上海市浦东新区', '妇产科资格证', '妇产科', '8年', '周一至周五上午8点至下午6点', '每月第二周休息', '电话：0987654321，电子邮件：li@example.com，在线咨询：https://example.com/li', '诊断结果：孕妇，治疗方案：产前检查');
INSERT INTO medical.doctors (name, age, gender, contact, address, certification, specialty, clinical_experience, schedule, leave_schedule, communication_records, medical_records) VALUES
    ('王医生', 45, '男', '1357924680', '广州市天河区', '外科资格证', '外科', '10年', '周一至周五上午8点至下午4点', '每周周六日休息', '电话：1357924680，电子邮件：wang@example.com，在线咨询：https://example.com/wang', '手术记录：阑尾切除手术');
INSERT INTO medical.doctors (name, age, gender, contact, address, certification, specialty, clinical_experience, schedule, leave_schedule, communication_records, medical_records) VALUES
    ('赵医生', 38, '女', '2468013579', '深圳市南山区', '内科资格证', '内科', '6年', '周一至周五上午10点至下午6点', '每月第三周休息', '电话：2468013579，电子邮件：zhao@example.com，在线咨询：https://example.com/zhao', '诊断结果：感冒，治疗方案：休息和药物治疗');
INSERT INTO medical.doctors (name, age, gender, contact, address, certification, specialty, clinical_experience, schedule, leave_schedule, communication_records, medical_records) VALUES
    ('刘医生', 42, '男', '9876543210', '成都市武侯区', '神经科资格证', '神经科', '7年', '周一至周五上午10点至下午6点', '每月第一周休息', '电话：9876543210，电子邮件：liu@example.com，在线咨询：https://example.com/liu', '诊断结果：头痛，治疗方案：药物治疗');


-- 创建药品信息管理表
CREATE TABLE medical.medicines (
    id INT AUTO_INCREMENT PRIMARY KEY, -- 药品ID，主键，自增
    name VARCHAR(100), -- 药品名称
    dosage VARCHAR(50), -- 用法用量
    interactions VARCHAR(255) -- 药品相互作用
);

-- 添加药品信息测试数据
INSERT INTO medical.medicines (name, dosage, interactions) VALUES
('阿司匹林', '口服，一次1片，一日3次', '与其他抗凝血药物同时使用时需注意');
INSERT INTO medical.medicines (name, dosage, interactions) VALUES
('布洛芬', '口服，一次2片，一日2次', '可能会引起胃肠道不适');
INSERT INTO medical.medicines (name, dosage, interactions) VALUES
('头孢', '静脉注射，一次1支，一日2次', '与其他抗生素同时使用时需谨慎');
INSERT INTO medical.medicines (name, dosage, interactions) VALUES
('阿莫西林', '口服，一次1片，一日3次', '可能会引起过敏反应');
INSERT INTO medical.medicines (name, dosage, interactions) VALUES
('氨茶碱', '口服，一次1片，一日2次', '可能会增加心脏负担');

-- 创建通知和提醒管理表
CREATE TABLE medical.notifications (
   id INT AUTO_INCREMENT PRIMARY KEY, -- 通知ID，主键，自增
   type VARCHAR(50), -- 通知类型，例如：预约提醒、药物提醒、诊断结果通知等
   doctor_id INT, -- 医生ID，外键，关联医生信息表
   patient_id INT, -- 患者ID，外键，关联患者信息表
   content TEXT, -- 通知内容
   created_at DATETIME, -- 通知创建时间
   status VARCHAR(20) -- 通知状态，例如：已发送、未发送、已读等
);


-- 添加更多测试数据到通知和提醒管理表
INSERT INTO medical.notifications (type, doctor_id, patient_id, content, created_at, status) VALUES
     ('预约提醒', 2, 1, '您的预约时间为2024-05-10下午2点，请提前15分钟到达。', '2024-05-09 15:30:00', '已发送'),
     ('药物提醒', 2, 2, '请记得按时服用阿莫西林，每日三次，饭后服用。', '2024-05-07 08:30:00', '未发送'),
     ('诊断结果通知', 5, 3, '您的诊断结果显示为高血压，请注意饮食，避免高盐高油食物。', '2024-05-08 10:45:00', '已读');

-- 用户表
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    role ENUM('doctor', 'nurse', 'admin', 'patient') NOT NULL,
    name VARCHAR(100) NOT NULL,
    gender ENUM('男', '女', '其他'),
    date_of_birth DATE,
    address VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

-- 用户表测试数据
INSERT INTO users (role, name, gender, date_of_birth, address, phone, email, password) 
VALUES 
('doctor', '张医生', '男', '1975-03-12', '上海市', '123456789', 'zhang@example.com', 'password123'),
('doctor', '王医生', '女', '1982-08-25', '北京市', '987654321', 'wang@example.com', 'securepass'),
('nurse', '李护士', '女', '1988-11-03', '广州市', '135792468', 'li@example.com', 'nursepass123'),
('nurse', '赵护士', '男', '1995-04-17', '深圳市', '246813579', 'zhao@example.com', 'securepass'),
('admin', '管理员1', '男', '1980-01-01', '上海市', '111111111', 'admin1@example.com', 'adminpass123'),
('admin', '管理员2', '女', '1978-07-20', '北京市', '222222222', 'admin2@example.com', 'securepass'),
('patient', '王患者', '男', '1990-05-15', '上海市', '333333333', 'wang_patient@example.com', 'patientpass'),
('patient', '李患者', '女', '1995-10-20', '北京市', '444444444', 'li_patient@example.com', 'patientpass');
