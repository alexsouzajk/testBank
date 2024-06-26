USE [master]
GO
/****** Object:  Database [test_bank]    Script Date: 07/05/2024 14:52:18 ******/
CREATE DATABASE [test_bank]
 CONTAINMENT = NONE

ALTER DATABASE [test_bank] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [test_bank].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [test_bank] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [test_bank] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [test_bank] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [test_bank] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [test_bank] SET ARITHABORT OFF 
GO
ALTER DATABASE [test_bank] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [test_bank] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [test_bank] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [test_bank] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [test_bank] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [test_bank] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [test_bank] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [test_bank] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [test_bank] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [test_bank] SET  ENABLE_BROKER 
GO
ALTER DATABASE [test_bank] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [test_bank] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [test_bank] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [test_bank] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [test_bank] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [test_bank] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [test_bank] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [test_bank] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [test_bank] SET  MULTI_USER 
GO
ALTER DATABASE [test_bank] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [test_bank] SET DB_CHAINING OFF 
GO
ALTER DATABASE [test_bank] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [test_bank] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [test_bank] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [test_bank] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [test_bank] SET QUERY_STORE = OFF
GO
USE [test_bank]
GO
USE [test_bank]
GO
/****** Object:  Sequence [dbo].[account_seq]    Script Date: 07/05/2024 14:52:18 ******/
CREATE SEQUENCE [dbo].[account_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [test_bank]
GO
/****** Object:  Sequence [dbo].[costumers_seq]    Script Date: 07/05/2024 14:52:18 ******/
CREATE SEQUENCE [dbo].[costumers_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
USE [test_bank]
GO
/****** Object:  Sequence [dbo].[transactions_seq]    Script Date: 07/05/2024 14:52:18 ******/
CREATE SEQUENCE [dbo].[transactions_seq] 
 AS [bigint]
 START WITH 1
 INCREMENT BY 50
 MINVALUE -9223372036854775808
 MAXVALUE 9223372036854775807
 CACHE 
GO
/****** Object:  Table [dbo].[account]    Script Date: 07/05/2024 14:52:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[balance] [numeric](15, 2) NULL,
	[id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 07/05/2024 14:52:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[age] [int] NULL,
	[account_id] [bigint] NULL,
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[email] [varchar](255) NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transactions]    Script Date: 07/05/2024 14:52:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transactions](
	[value] [numeric](38, 2) NULL,
	[date] [datetime2](6) NULL,
	[destination_account_id] [bigint] NULL,
	[id] [bigint] NOT NULL,
	[origin_account_id] [bigint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Index [UK_jwt2qo9oj3wd7ribjkymryp8s]    Script Date: 07/05/2024 14:52:18 ******/
CREATE UNIQUE NONCLUSTERED INDEX [UK_jwt2qo9oj3wd7ribjkymryp8s] ON [dbo].[customer]
(
	[account_id] ASC
)
WHERE ([account_id] IS NOT NULL)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UK_42tlqsrn2wtg2mcr4qyhfjbfw]    Script Date: 07/05/2024 14:52:18 ******/
CREATE UNIQUE NONCLUSTERED INDEX [UK_42tlqsrn2wtg2mcr4qyhfjbfw] ON [dbo].[transactions]
(
	[destination_account_id] ASC
)
WHERE ([destination_account_id] IS NOT NULL)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UK_9awajas4mt4cwquqlwgdmotmt]    Script Date: 07/05/2024 14:52:18 ******/
CREATE UNIQUE NONCLUSTERED INDEX [UK_9awajas4mt4cwquqlwgdmotmt] ON [dbo].[transactions]
(
	[origin_account_id] ASC
)
WHERE ([origin_account_id] IS NOT NULL)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[customer]  WITH CHECK ADD  CONSTRAINT [FKn9x2k8svpxj3r328iy1rpur83] FOREIGN KEY([account_id])
REFERENCES [dbo].[account] ([id])
GO
ALTER TABLE [dbo].[customer] CHECK CONSTRAINT [FKn9x2k8svpxj3r328iy1rpur83]
GO
ALTER TABLE [dbo].[transactions]  WITH CHECK ADD  CONSTRAINT [FK5k2ysgfq7jhdkbrrg1473knlw] FOREIGN KEY([origin_account_id])
REFERENCES [dbo].[account] ([id])
GO
ALTER TABLE [dbo].[transactions] CHECK CONSTRAINT [FK5k2ysgfq7jhdkbrrg1473knlw]
GO
ALTER TABLE [dbo].[transactions]  WITH CHECK ADD  CONSTRAINT [FKd7t7fgufnjq14mgrmnco7wns7] FOREIGN KEY([destination_account_id])
REFERENCES [dbo].[account] ([id])
GO
ALTER TABLE [dbo].[transactions] CHECK CONSTRAINT [FKd7t7fgufnjq14mgrmnco7wns7]
GO
USE [master]
GO
ALTER DATABASE [test_bank] SET  READ_WRITE 
GO
