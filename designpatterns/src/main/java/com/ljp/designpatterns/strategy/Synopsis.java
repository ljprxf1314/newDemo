package com.ljp.designpatterns.strategy;

/**
 * 网络小说的故事梗概接口
 * 固定的一些套路
 * @author lijipei
 *
 */
public interface Synopsis {

	/**
	 * 穷困潦倒的开始
	 */
	void badStart();
	/**
	 * 突然有天遇到神人/捡到神器,实力大增
	 */
	void adventure();

	/**
	 * 在一场战斗中以弱胜强
	 */
	void winABattle();
	/**
	 * 从此飞速成长
	 */
	void growFast();

	/**
	 * 组团杀怪,经历九死一生(主角怎么也死不了)
	 */
	void manyFights();

	/**
	 * 最终功成名就,妻妾成群
	 */
	void succeed();

	/**
	 * 组合起来就是小说内容
	 */
	void getContent();
}
