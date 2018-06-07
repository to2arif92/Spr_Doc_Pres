/* UserConnection - needed by JdbcUsersConnectionRepository (SPRING SOCIAL) */
create table UserConnection (
  userId varchar(255) not null,
  providerId varchar(255) not null,
  providerUserId varchar(255),
  rank int not null,
  displayName varchar(255),
  profileUrl varchar(512),
  imageUrl varchar(512),
  accessToken varchar(512) not null,
  secret varchar(512),
  refreshToken varchar(512),
  expireTime bigint,
  primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

/* userId is here FK of id from User Table; thus a user can only be deleted after deleting the child(UserConnection) */
ALTER TABLE userconnection
  ADD CONSTRAINT user___fk
FOREIGN KEY (userId) REFERENCES user (id);