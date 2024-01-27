insert into t_user (id, first_name, last_name, phone, e_mail, password)
values
    ('c3bc1203-ec7f-428d-a4aa-01c0c3b40abd', 'nils', 'rothe', '0773434334', 'nilsrothe05@gmail.com', 'test' ),
    ('c3bc1203-ec7f-428d-a4aa-01c0c3b40a34', 'globi', 'test', '0773434334', 'globi@gmail.com', 'test2' )
ON DUPLICATE KEY UPDATE id = id;


insert into t_ressort (id, name, description)
values ('bbed43d2-5055-4b38-b809-060c34ac42d2', 'Webseite', 'Zuständig für die Webseite')
ON DUPLICATE KEY UPDATE id = id;


insert ignore into t_user_ressort (user_id, ressort_id)
values ('c3bc1203-ec7f-428d-a4aa-01c0c3b40abd', 'bbed43d2-5055-4b38-b809-060c34ac42d2');

insert into t_role (id, name)
VALUES
    ('a6e1543e-6d1f-4821-ac22-0b355243dde1', 'ADMIN'),
    ('e4477fdb-611e-4096-a7aa-86735564aeae', 'LEADER')
ON DUPLICATE KEY UPDATE id = id;

insert ignore into t_user_role (user_id, role_id)
VALUES
    ('c3bc1203-ec7f-428d-a4aa-01c0c3b40abd', 'a6e1543e-6d1f-4821-ac22-0b355243dde1'),
    ('c3bc1203-ec7f-428d-a4aa-01c0c3b40a34', 'e4477fdb-611e-4096-a7aa-86735564aeae');






