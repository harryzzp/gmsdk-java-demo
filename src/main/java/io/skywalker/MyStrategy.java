package io.skywalker;

import io.skywalker.gmsdk.Bar;
import io.skywalker.gmsdk.Strategy;

/**
 * 
 * @author Harry Zhou
 *
 */
public class MyStrategy extends Strategy {

	public void on_init() {
		System.out.println("on_init");
		// 订阅浦发银行, bar频率为一天
		subscribe("SHSE.600000", "1d");
	}

	public void on_bar(Bar bar) {
		System.out.println("代码:            " + bar.getSymbol());
		System.out.println("bar的开始时间:   " + bar.getBob());
		System.out.println("bar的结束时间:   " + bar.getEob());
		System.out.println("开盘价:          " + bar.getOpen());
		System.out.println("收盘价:          " + bar.getClose());
		System.out.println("最高价:          " + bar.getHigh());
		System.out.println("最低价:          " + bar.getLow());
		System.out.println("成交量:          " + bar.getVolume());
		System.out.println("成交金额:        " + bar.getAmount());
		System.out.println("前收盘价:        " + bar.getPre_close());
		System.out.println("持仓量:          " + bar.getPosition());
		System.out.println("bar频度:         " + bar.getFrequency());
	}

}
