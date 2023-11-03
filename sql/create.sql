-- video.fileUpload definition

create database video;
use video;

CREATE TABLE `fileUpload` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '自增，无业务意义',
  `attach_group_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '文件id',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '原文件名称',
  `url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '保存地址',
  `createTime` datetime NOT NULL COMMENT '放入时间',
  `profilx` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '文件类型',
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT ' 文件类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `fileUpload_UN` (`attach_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1699 DEFAULT CHARSET=utf8mb3 COMMENT='文件保存表';


-- video.photoInfo definition

CREATE TABLE `photoInfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `videoInfoId` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `attach_group_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1668 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- video.userInfo definition

CREATE TABLE `userInfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '名称',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- video.videoInfo definition

CREATE TABLE `videoInfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '视频名称',
  `descri` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述信息',
  `attachGroupId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件id',
  `userInfoId` int NOT NULL,
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(2) NOT NULL DEFAULT '0' COMMENT '视频是否已经处理',
  `attgroupid1` varchar(255) DEFAULT NULL COMMENT '封面图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='保存上传视频信息';