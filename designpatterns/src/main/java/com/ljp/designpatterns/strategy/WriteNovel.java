package com.ljp.designpatterns.strategy;
/**
 * 写小说
 * @author lijipei
 *
 */
public class WriteNovel {

	private Synopsis mSynopsis;//故事梗概
	private String mMainActorName;//故事主角
	/**
	 * 梗概、内容都差不多确定后,换个名称就是另一部小说
	 * @param mMainActorName
	 */
	public WriteNovel(String mMainActorName) {
		switch(mMainActorName){
			case "张小凡":
				mSynopsis = new StoryB(mMainActorName);
				break;
			case "杜维":
				mSynopsis = new StoryA(mMainActorName);
				break;
			default:
				mSynopsis = new StoryB(mMainActorName);
				break;
		}
	}

	/**
	 * 获取小说内容
	 */
	public void getNovelDetail() {
		mSynopsis.getContent();
	}

	public static void main(String[] args) {
		WriteNovel writeNovel = new WriteNovel("张拭心");
		writeNovel.getNovelDetail();
	}

}