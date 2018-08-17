package com.ljp.designpatterns.strategy;

/**
 * 故事B:诛仙
 * @author lijipei
 *
 */
public class StoryB implements Synopsis{

	private String name;

	public StoryB(String name) {
		super();
		this.name = name;
	}

	@Override
	public void badStart() {
		// TODO Auto-generated method stub
		System.out.println(name+"全村被屠,投入青云七脉中人数最少的大竹峰");
	}

	@Override
	public void adventure() {
		// TODO Auto-generated method stub
		System.out.println(name+"在一次伐竹过程中,为追一只三眼灵猴,入青云山深处得到了烧火棍");
	}

	@Override
	public void winABattle() {
		// TODO Auto-generated method stub
		System.out.println(name+"在七脉会武中侥幸进了前4,和陆雪琪等人进入万蝠古窟历练");
	}

	@Override
	public void growFast() {
		// TODO Auto-generated method stub
		System.out.println(name+"在魔教十年,深的鬼王器重和真传");
	}

	@Override
	public void manyFights() {
		// TODO Auto-generated method stub
		System.out.println(name+"经历无数战斗,先为鬼王卖命,后来与鬼王大战");
	}

	@Override
	public void succeed() {
		// TODO Auto-generated method stub
		System.out.println("天地不仁以万物为刍狗"+name+"成为最有资格拥有天书的人");
	}

	@Override
	public void getContent() {
		// TODO Auto-generated method stub
		badStart();
		adventure();
		winABattle();
		growFast();
		manyFights();
		succeed();
	}

}