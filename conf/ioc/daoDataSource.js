var ioc = {
	// 读取配置文件
    config : {
        type : "org.nutz.ioc.impl.PropertiesProxy",
        fields : {
            /*paths : ["ioc/dataSource.properties"]*/
			paths : ["dataSource.properties"]
        }
    },
	dataSource : {
		type : "com.alibaba.druid.pool.DruidDataSource",
		events : {
              depose : 'close'
		},
		 fields : {
	            driverClassName : {java :"$config.get('db-driver')"},
	            url             : {java :"$config.get('db-url')"},
	            username        : {java :"$config.get('db-username')"},
	            password        : {java :"$config.get('db-password')"},
	            initialSize     : 10,
	            maxActive       : 100,
	            testOnReturn    : true,
	            //validationQueryTimeout : 5,
	            validationQuery : "select 1"
	        }
	},
	dao : {
		type : "org.nutz.dao.impl.NutDao",
		args : [{refer:'dataSource'}]
	}
};