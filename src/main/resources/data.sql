------------------------------CATEGORY TABLE---------------------------------------
INSERT INTO categories (category_name) VALUES('Crops');
INSERT INTO categories (category_name) VALUES('Fruits');
INSERT INTO categories (category_name) VALUES('Vegetables');

------------------------------ITEM TABLE--------------------------------------------
INSERT INTO items (item_name, category_id) VALUES ('Rice', SELECT category_id FROM categories WHERE category_name = 'Crops');
INSERT INTO items (item_name, category_id) VALUES ('Wheat', SELECT category_id FROM categories WHERE category_name = 'Crops');
INSERT INTO items (item_name, category_id) VALUES ('Orange', SELECT category_id FROM categories WHERE category_name = 'Fruits');
INSERT INTO items (item_name, category_id) VALUES ('Apple', SELECT category_id FROM categories WHERE category_name = 'Fruits');
INSERT INTO items (item_name, category_id) VALUES ('Tomato', SELECT category_id FROM categories WHERE category_name = 'Vegetables');
INSERT INTO items (item_name, category_id) VALUES ('Onion', SELECT category_id FROM categories WHERE category_name = 'Vegetables');

------------------------------ROLE TABLE--------------------------------------------
INSERT INTO roles (role_name) VALUES ('Admin');
INSERT INTO roles (role_name) VALUES ('Farmer');
INSERT INTO roles (role_name) VALUES ('Retailer');

-----------------------------USERS TABLE--------------------------------------------
INSERT INTO users (user_name, password, first_name, last_name, email_id, phone_number, address, city, zip_code, role_id) VALUES (
	'naren9990', '$2y$12$7Mc11EUifNM1b0xITYTmSezBiUh4cw29A7xcC3Nx49VFExCKIHrNC', 'Narendran', 'Arumugavadivelu', 'naren9990@gmail.com', '9629009410', '215, Sathyamoorthy Road, Ramnagar', 'Coimbatore', '641009', SELECT role_id FROM roles WHERE role_name = 'Admin');
INSERT INTO users (user_name, password, first_name, last_name, email_id, phone_number, address, city, zip_code, role_id) VALUES (
	'naren9991', '$2y$12$7Mc11EUifNM1b0xITYTmSezBiUh4cw29A7xcC3Nx49VFExCKIHrNC', 'Karthik', 'Arumugavadivelu', 'naren9991@gmail.com', '9629009410', '215, Sathyamoorthy Road, Ramnagar', 'Chennai', '600101', SELECT role_id FROM roles WHERE role_name = 'Farmer');
INSERT INTO users (user_name, password, first_name, last_name, email_id, phone_number, address, city, zip_code, role_id) VALUES (
	'naren9992', '$2y$12$7Mc11EUifNM1b0xITYTmSezBiUh4cw29A7xcC3Nx49VFExCKIHrNC', 'Ajith', 'Kumar', 'naren9992@gmail.com', '9629009410', '215, Sathyamoorthy Road, Ramnagar', 'Chennai', '600087', SELECT role_id FROM roles WHERE role_name = 'Farmer');	
INSERT INTO users (user_name, password, first_name, last_name, email_id, phone_number, address, city, zip_code, role_id) VALUES (
	'naren9993', '$2y$12$7Mc11EUifNM1b0xITYTmSezBiUh4cw29A7xcC3Nx49VFExCKIHrNC', 'Sunvika', 'Karthik', 'naren9993@gmail.com', '9629009410', '215/1, Mount Road', 'Chennai', '600091', SELECT role_id FROM roles WHERE role_name = 'Retailer');
INSERT INTO users (user_name, password, first_name, last_name, email_id, phone_number, address, city, zip_code, role_id) VALUES (
	'naren9994', '$2y$12$7Mc11EUifNM1b0xITYTmSezBiUh4cw29A7xcC3Nx49VFExCKIHrNC', 'Tanika', 'Karthik', 'naren9990@gmail.com', '9629009410', '215/5, Mount Road', 'Chennai', '600101', SELECT role_id FROM roles WHERE role_name = 'Retailer');	
INSERT INTO users (user_name, password, first_name, last_name, email_id, phone_number, address, city, zip_code, role_id) VALUES (
	'naren9995', '$2y$12$7Mc11EUifNM1b0xITYTmSezBiUh4cw29A7xcC3Nx49VFExCKIHrNC', 'Saranya', 'Shanmugam', 'naren9995@gmail.com', '9629009410', '215/5, Mount Road', 'Coimbatore', '641002', SELECT role_id FROM roles WHERE role_name = 'Farmer');	
INSERT INTO users (user_name, password, first_name, last_name, email_id, phone_number, address, city, zip_code, role_id) VALUES (
	'naren9996', '$2y$12$7Mc11EUifNM1b0xITYTmSezBiUh4cw29A7xcC3Nx49VFExCKIHrNC', 'Tariq', 'Ahmed', 'naren9996@gmail.com', '9629009410', '215/5, Mount Road', 'Coimbatore', '641035', SELECT role_id FROM roles WHERE role_name = 'Farmer');	
INSERT INTO users (user_name, password, first_name, last_name, email_id, phone_number, address, city, zip_code, role_id) VALUES (
	'naren9997', '$2y$12$7Mc11EUifNM1b0xITYTmSezBiUh4cw29A7xcC3Nx49VFExCKIHrNC', 'Muthu', 'Prakash', 'naren9997@gmail.com', '9629009410', '215/5, Mount Road', 'Coimbatore', '641009', SELECT role_id FROM roles WHERE role_name = 'Retailer');	
INSERT INTO users (user_name, password, first_name, last_name, email_id, phone_number, address, city, zip_code, role_id) VALUES (
	'naren9998', '$2y$12$7Mc11EUifNM1b0xITYTmSezBiUh4cw29A7xcC3Nx49VFExCKIHrNC', 'Raghu', 'Pathy', 'naren9998@gmail.com', '9629009410', '215/5, Mount Road', 'Coimbatore', '641101', SELECT role_id FROM roles WHERE role_name = 'Retailer');		

	