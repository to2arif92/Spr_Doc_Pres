/* User Privilege */
INSERT INTO doctor_prescription.user_privilege (privilegeID, privilegeType) VALUES (1, 'ADMIN');
INSERT INTO doctor_prescription.user_privilege (privilegeID, privilegeType) VALUES (2, 'USER');

/* Users */
INSERT INTO doctor_prescription.user (userName, id, lastSigned, loginStatus, regDate, userPassword, privilegeID) VALUES ('admin', '2', null, true, null, '12', 2);
INSERT INTO doctor_prescription.user (userName, id, lastSigned, loginStatus, regDate, userPassword, privilegeID) VALUES ('ar', '1', null, true, null, '12', 1);
INSERT INTO doctor_prescription.user (userName, id, lastSigned, loginStatus, regDate, userPassword, privilegeID) VALUES ('user', '3', null, true, null, '12', 2);