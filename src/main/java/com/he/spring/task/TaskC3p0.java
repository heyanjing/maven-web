package com.he.spring.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.he.spring.base.util.Springs;
import com.he.spring.util.Dates;
import com.mchange.v2.c3p0.PooledDataSource;

@Component
public class TaskC3p0 {
	private PooledDataSource pooledDatasource;


	@Scheduled(cron = "*/20 * * * * ? ")
	public void run() throws Exception {
		if(this.pooledDatasource==null){
			this.pooledDatasource = Springs.getBean("dataSource");
		}
		String msg = "";
		msg += "============================== 数据源状态报告 ==============================\n";
		msg += "CurrentTime：" + Dates.newDateString("yyyy-MM-dd HH:mm:ss.SSS") + "\n";
		msg += "TotalConnections：" + this.pooledDatasource.getNumConnectionsAllUsers() + "\n";
		msg += "BusyConnections：" + this.pooledDatasource.getNumBusyConnectionsAllUsers() + "\n";
		msg += "IdleConnections：" + this.pooledDatasource.getNumIdleConnectionsAllUsers() + "\n";
		msg += "FailedCheckins：" + this.pooledDatasource.getNumFailedCheckinsDefaultUser() + "\n";
		msg += "FailedCheckouts：" + this.pooledDatasource.getNumFailedCheckoutsDefaultUser() + "\n";
		msg += "FailedIdleTests：" + this.pooledDatasource.getNumFailedIdleTestsDefaultUser() + "\n";
		msg += "UnclosedOrphanedConnections：" + this.pooledDatasource.getNumUnclosedOrphanedConnectionsAllUsers() + "\n";
		msg += "StatementCacheNumStatements：" + this.pooledDatasource.getStatementCacheNumStatementsAllUsers() + "\n";
		msg += "StatementCacheNumCheckedOutStatements：" + this.pooledDatasource.getStatementCacheNumCheckedOutStatementsAllUsers() + "\n";
		msg += "StatementCacheNumConnectionsWithCachedStatements：" + this.pooledDatasource.getStatementCacheNumConnectionsWithCachedStatementsAllUsers() + "\n";
		msg += "============================== 数据源状态报告 ==============================";
		System.out.println(msg);
	}
}
