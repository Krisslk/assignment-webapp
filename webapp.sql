CREATE TABLE customers (
    customerID int not null auto_increment primary key,
    patientName varchar(255),
    NICNo varchar(255),
    PINCode varchar(8),
    phoneNo varchar(10)
);

CREATE TABLE appointments (
    appointmentID int not null auto_increment primary key,
    customerId int(55) not null,
    testId int(55) not null,
    doctorId int(55) not null,
    appointmentDate date,
    description longText,
    status varchar(255)
);

CREATE TABLE tests (
    testID int not null auto_increment primary key,
    testName varchar(255)
);

INSERT INTO tests (testName) VALUES 
('Blood Glucose Test'),
('MRI Scan'),
('Electrocardiogram (ECG)'),
('Urinalysis'),
('X-ray');


CREATE TABLE doctors (
    doctorID int not null auto_increment primary key,
    doctorName varchar(255),
    phoneNo varchar(10),
    medicalId int not null
);

INSERT INTO doctors (doctorName, phoneNo, medicalId) VALUES 
('Dr. John Smith', '1234567890', 1001),
('Dr. Emily Johnson', '2345678901', 1002),
('Dr. Michael Brown', '3456789012', 1003),
('Dr. Sarah Lee', '4567890123', 1004),
('Dr. David Rodriguez', '5678901234', 1005);



ALTER TABLE appointments ADD CONSTRAINT fk_customer_id FOREIGN KEY (customerId) REFERENCES customers(customerID);
ALTER TABLE appointments ADD CONSTRAINT fk_test_id FOREIGN KEY (testId) REFERENCES tests(testId);
ALTER TABLE appointments ADD CONSTRAINT fk_doctor_id FOREIGN KEY (doctorId) REFERENCES doctors(doctorId);


CREATE TABLE users (
    userID int not null auto_increment primary key,
    username varchar(255),
    userType varchar(255),
    password varchar(255)
);

insert into users (username,password,userType) values("saman","think100%","Technician");
