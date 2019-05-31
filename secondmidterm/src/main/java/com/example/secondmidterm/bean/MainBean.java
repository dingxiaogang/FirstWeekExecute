package com.example.secondmidterm.bean;

import java.util.List;

public class MainBean {
    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"谷歌开发者","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3289,"link":"https://www.jianshu.com/p/3a333d643ee0","niceDate":"2018-08-20","origin":"","prefix":"","projectLink":"","publishTime":1534765814000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 9 的非 SDK 接口限制 | 中文教学视频","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2902,"link":"https://www.jianshu.com/p/d76105b8ec30","niceDate":"2018-05-10","origin":"","prefix":"","projectLink":"","publishTime":1525933907000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 8.0 Oreo 画中画模式","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"奇卓社","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2811,"link":"http://mp.weixin.qq.com/s/4k3DBlxlSO2xNNKqjqUdaQ","niceDate":"2018-04-12","origin":"","prefix":"","projectLink":"","publishTime":1523533421000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"突破Android P(Preview 1)对调用隐藏API限制的方法","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2694,"link":"https://mp.weixin.qq.com/s/YY7bulNGdIv9sNRjpPH7ZA","niceDate":"2018-03-22","origin":"","prefix":"","projectLink":"","publishTime":1521721492000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"满足 Google Play 目标 API 等级 (targetSdkLevel) 的要求","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2462,"link":"http://www.wanandroid.com/blog/show/2073","niceDate":"2018-03-09","origin":"","prefix":"","projectLink":"","publishTime":1520583007000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"[快讯] Android P 开发者预览版","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"移动开发前线","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2434,"link":"https://mp.weixin.qq.com/s/gICH9osyIzz9WerXO1C_8g","niceDate":"2018-03-02","origin":"","prefix":"","projectLink":"","publishTime":1519961226000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"谷歌确认将限制Android非SDK接口使用了","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"一只有交流障碍的丑程序猿","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1837,"link":"https://juejin.im/post/5a3b9de2f265da43085e336b","niceDate":"2018-01-04","origin":"","prefix":"","projectLink":"","publishTime":1515037605000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android8.0 新SupportLibrary26、27功能及变化介绍","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":7}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":"谷歌开发者","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":3289,"link":"https://www.jianshu.com/p/3a333d643ee0","niceDate":"2018-08-20","origin":"","prefix":"","projectLink":"","publishTime":1534765814000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 9 的非 SDK 接口限制 | 中文教学视频","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2902,"link":"https://www.jianshu.com/p/d76105b8ec30","niceDate":"2018-05-10","origin":"","prefix":"","projectLink":"","publishTime":1525933907000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android 8.0 Oreo 画中画模式","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"奇卓社","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2811,"link":"http://mp.weixin.qq.com/s/4k3DBlxlSO2xNNKqjqUdaQ","niceDate":"2018-04-12","origin":"","prefix":"","projectLink":"","publishTime":1523533421000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"突破Android P(Preview 1)对调用隐藏API限制的方法","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"谷歌开发者","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2694,"link":"https://mp.weixin.qq.com/s/YY7bulNGdIv9sNRjpPH7ZA","niceDate":"2018-03-22","origin":"","prefix":"","projectLink":"","publishTime":1521721492000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"满足 Google Play 目标 API 等级 (targetSdkLevel) 的要求","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2462,"link":"http://www.wanandroid.com/blog/show/2073","niceDate":"2018-03-09","origin":"","prefix":"","projectLink":"","publishTime":1520583007000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"[快讯] Android P 开发者预览版","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"移动开发前线","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2434,"link":"https://mp.weixin.qq.com/s/gICH9osyIzz9WerXO1C_8g","niceDate":"2018-03-02","origin":"","prefix":"","projectLink":"","publishTime":1519961226000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"谷歌确认将限制Android非SDK接口使用了","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"一只有交流障碍的丑程序猿","chapterId":269,"chapterName":"官方发布","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":1837,"link":"https://juejin.im/post/5a3b9de2f265da43085e336b","niceDate":"2018-01-04","origin":"","prefix":"","projectLink":"","publishTime":1515037605000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Android8.0 新SupportLibrary26、27功能及变化介绍","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 7
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * author : 谷歌开发者
             * chapterId : 269
             * chapterName : 官方发布
             * collect : false
             * courseId : 13
             * desc :
             * envelopePic :
             * fresh : false
             * id : 3289
             * link : https://www.jianshu.com/p/3a333d643ee0
             * niceDate : 2018-08-20
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1534765814000
             * superChapterId : 60
             * superChapterName : 开发环境
             * tags : []
             * title : Android 9 的非 SDK 接口限制 | 中文教学视频
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
