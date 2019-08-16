
    
	//按照省份的下拉列表的顺序定义二维数组  将城市列表对应到省份下
	var city=[
        ["杭州市","温州市","宁波市","绍兴市"],//浙江省
        ["济南市","青岛市","济宁市","潍坊市"],//山东省
        ["广州市","潮阳","澄海","潮州"],//广东省
        ["兰州市","白银","敦煌","定西"]//甘肃省
    ];

    //县区数组
    var qu=[
        [
                ["杭州一区","杭州二区"],
                ["温州一区","温州二区"],
                ["宁波一区","宁波二区"],
                ["绍兴一区","绍兴二区"]
        ],

        [
                ["济南一区","济南二区"],
                ["青岛一区","青岛二区"],
                ["济宁一区","济宁二区"],
                ["潍坊一区","潍坊二区"],
        ],

        [
                ["广州一区","广州二区"],
                ["潮阳一区","潮阳二区"],
                ["澄海一区","澄海二区"],
                ["潮州一区","潮州二区"],
        ],

        [
                ["兰州一区","兰州二区"],
                ["白银一区","白银二区"],
                ["敦煌一区","敦煌二区"],
                ["定西一区","定西二区"],
        ]

    ];
    var getProvince = document.forms['theform'].locationprovince;
    var City = document.forms[0].locationcity;
    var Qu = document.forms[0].locationqu;
    function getCity(){
        // 初始化
        Qu.length = 1;
        City.length = 1;
        // 获得 省份选择的项（索引值，0开始）
        var getSelectIndex = getProvince.selectedIndex;
        // 匹配选择省下面的 市区
        var proCity = city[getSelectIndex-1]; // 
        console.log( proCity)
        for( var i=0; i<proCity.length; i++){
            City[i+1] = new Option(proCity[i],getSelectIndex)
        }
    }

    function getQu(){
        var getSelectIndex = getProvince.selectedIndex;  // 省
        var getCitySelectedIndex = City.selectedIndex; // 市
        console.log( getCitySelectedIndex )
        var cityQu = qu[getSelectIndex - 1][ getCitySelectedIndex - 1];
        console.log( cityQu )

        for( var i=0; i<cityQu.length; i++){
            Qu[i+1] = new Option(cityQu[0],getCitySelectedIndex)
        }
    }
