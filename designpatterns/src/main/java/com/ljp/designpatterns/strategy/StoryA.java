package com.ljp.designpatterns.strategy;
/**
 * 故事A:恶魔法则
 * @author lijipei
 *
 */
public class StoryA implements Synopsis{

	private String name;

	public StoryA(String name) {
		super();
		this.name = name;
	}

	@Override
	public void badStart() {
		// TODO Auto-generated method stub
		System.out.println(name+"无故穿越,因为没有魔法能力,成为将军家的废物,不受待见");
	}

	@Override
	public void adventure() {
		// TODO Auto-generated method stub
		System.out.println(name+"因为意外来到恶魔岛,在恶魔岛上遇到恶魔仆人,获得了一直想要使用魔法的能力");
	}

	@Override
	public void winABattle() {
		// TODO Auto-generated method stub
		System.out.println(name+"协助辰皇子夺得帝国的权力,成为郁金香公爵");
	}

	@Override
	public void growFast() {
		// TODO Auto-generated method stub
		System.out.println(name+"先后的曾曾曾祖母、恶魔的仆人、圣骑士、魔导师帮助下迅速成长");
	}

	@Override
	public void manyFights() {
		// TODO Auto-generated method stub
		System.out.println(name+"建立魔法学院和魔法学会,与魔法工会分庭抗礼.坐拥西北十万雄兵,歼灭西北军团,打退草原人,带领人类全族击退北方的异族军队");
	}

	@Override
	public void succeed() {
		// TODO Auto-generated method stub
		System.out.println(name+"娶女皇为妻,成为罗兰帝国英雄");
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
