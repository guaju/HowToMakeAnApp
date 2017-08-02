package com.guaju.howtomakeanapp.bean;

import java.util.List;

/**
 * Created by guaju on 2017/8/1.
 */

public class ADSBean {


    /**
     * status : success
     * success : true
     * data : [{"banner":[{"id":71,"type":5,"img":"goodsimg/1496742097579.jpg","url":"2","is_alone":1},{"id":65,"type":1,"img":"goodsimg/1496742499947.jpg","url":"http://www.baidu.com","is_alone":1},{"id":58,"type":1,"img":"goodsimg/1496745468962.jpg","url":"http://www.baidu.com","is_alone":1},{"id":72,"type":1,"img":"goodsimg/1496746040934.jpg","url":"http://www.baidu.com","is_alone":1}],"activity":[{"id":7,"title":"生鲜美食","content":"","type":1,"goods_ids":"260,262,263","memo":"甄选全球食材，安心之选，爱上下厨","sort":0,"images":"goodsimg/1498792918776.jpg","stop_time":"2018-01-03 23:59:00","start_time":"2017-06-27 00:00:00","is_del":1,"contents":"<p>00&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;<\/p>","created_at":"2016-11-01 09:30:50","updated_at":"2017-06-30 14:11:02","type_id":206,"list":[{"id":260,"list_img":"goodsimg/1496912693470.jpg?imageMogr2/thumbnail/400x400!","name":"黑加仑葡萄干","sell_price":20,"type":1,"spec_array":[]},{"id":263,"list_img":"goodsimg/1496912828734.jpg?imageMogr2/thumbnail/400x400!","name":"纸皮巴旦木","sell_price":80,"type":1,"spec_array":[]}]}],"huodong":[{"id":25,"type":3,"img":"goodsimg/1478771708459.jpg","url":"8","is_alone":1},{"id":68,"type":1,"img":"goodsimg/1496052830862.jpg","url":"","is_alone":1},{"id":67,"type":1,"img":"goodsimg/1496051657641.jpg","url":"","is_alone":1}],"chaoji":{"id":45,"type":2,"img":"goodsimg/1500723901773.jpg","url":"257","is_alone":1},"goods":[{"id":183,"list_img":"goodsimg/1496893433651.jpg?imageMogr2/thumbnail/400x400!","name":"枫叶棒棒糖","memo":"","parent_id":"3139,3140,3141,3142","sell_price":18,"market_price":18,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":189,"list_img":"goodsimg/1498359809642.jpg?imageMogr2/thumbnail/400x400!","name":"韦伯护肝胶囊","memo":"","parent_id":"3139,3140,3141,3142","sell_price":158,"market_price":158,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":193,"list_img":"goodsimg/1496896699386.jpg?imageMogr2/thumbnail/400x400!","name":"自然之宝钙糖","memo":"vhukgjiklhjklhkl；","parent_id":"3139,3140,3141,3142","sell_price":1,"market_price":186,"is_friday":1,"distribution_type":3,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":257,"list_img":"goodsimg/1496912379958.jpg?imageMogr2/thumbnail/400x400!","name":"大杏仁","memo":"","parent_id":"3139,3140,3141,3142","sell_price":35,"market_price":0,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":274,"list_img":"goodsimg/1497070382948.jpg?imageMogr2/thumbnail/400x400!","name":"婴幼儿初榨 核桃油DHA","memo":"","parent_id":"3139,3140,3141,3142","sell_price":188,"market_price":188,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":346,"list_img":"goodsimg/1499693957021.jpg?imageMogr2/thumbnail/400x400!","name":"芦笋","memo":"","parent_id":"3139,3140,3141,3142","sell_price":1,"market_price":1,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":362,"list_img":"goodsimg/1501146314989.jpg?imageMogr2/thumbnail/400x400!","name":"可口可乐","memo":"","parent_id":"","sell_price":3,"market_price":3.5,"is_friday":1,"distribution_type":3,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":375,"list_img":"goodsimg/1501406782517.jpg?imageMogr2/thumbnail/400x400!","name":"油麦菜","memo":"","parent_id":"","sell_price":1,"market_price":0,"is_friday":1,"distribution_type":3,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":409,"list_img":"goodsimg/1501503047759.jpg?imageMogr2/thumbnail/400x400!","name":"小米椒","memo":"","parent_id":"","sell_price":1,"market_price":0,"is_friday":2,"distribution_type":1,"type":1,"spec_array":[],"is_sell":1,"is_spec":0}],"friday":{"date":"2017/08/04 00:00:00","type":1,"sun":205930}}]
     * msg : 
     */

    private String status;
    private boolean success;
    private String msg;
    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * banner : [{"id":71,"type":5,"img":"goodsimg/1496742097579.jpg","url":"2","is_alone":1},{"id":65,"type":1,"img":"goodsimg/1496742499947.jpg","url":"http://www.baidu.com","is_alone":1},{"id":58,"type":1,"img":"goodsimg/1496745468962.jpg","url":"http://www.baidu.com","is_alone":1},{"id":72,"type":1,"img":"goodsimg/1496746040934.jpg","url":"http://www.baidu.com","is_alone":1}]
         * activity : [{"id":7,"title":"生鲜美食","content":"","type":1,"goods_ids":"260,262,263","memo":"甄选全球食材，安心之选，爱上下厨","sort":0,"images":"goodsimg/1498792918776.jpg","stop_time":"2018-01-03 23:59:00","start_time":"2017-06-27 00:00:00","is_del":1,"contents":"<p>00&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;<\/p>","created_at":"2016-11-01 09:30:50","updated_at":"2017-06-30 14:11:02","type_id":206,"list":[{"id":260,"list_img":"goodsimg/1496912693470.jpg?imageMogr2/thumbnail/400x400!","name":"黑加仑葡萄干","sell_price":20,"type":1,"spec_array":[]},{"id":263,"list_img":"goodsimg/1496912828734.jpg?imageMogr2/thumbnail/400x400!","name":"纸皮巴旦木","sell_price":80,"type":1,"spec_array":[]}]}]
         * huodong : [{"id":25,"type":3,"img":"goodsimg/1478771708459.jpg","url":"8","is_alone":1},{"id":68,"type":1,"img":"goodsimg/1496052830862.jpg","url":"","is_alone":1},{"id":67,"type":1,"img":"goodsimg/1496051657641.jpg","url":"","is_alone":1}]
         * chaoji : {"id":45,"type":2,"img":"goodsimg/1500723901773.jpg","url":"257","is_alone":1}
         * goods : [{"id":183,"list_img":"goodsimg/1496893433651.jpg?imageMogr2/thumbnail/400x400!","name":"枫叶棒棒糖","memo":"","parent_id":"3139,3140,3141,3142","sell_price":18,"market_price":18,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":189,"list_img":"goodsimg/1498359809642.jpg?imageMogr2/thumbnail/400x400!","name":"韦伯护肝胶囊","memo":"","parent_id":"3139,3140,3141,3142","sell_price":158,"market_price":158,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":193,"list_img":"goodsimg/1496896699386.jpg?imageMogr2/thumbnail/400x400!","name":"自然之宝钙糖","memo":"vhukgjiklhjklhkl；","parent_id":"3139,3140,3141,3142","sell_price":1,"market_price":186,"is_friday":1,"distribution_type":3,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":257,"list_img":"goodsimg/1496912379958.jpg?imageMogr2/thumbnail/400x400!","name":"大杏仁","memo":"","parent_id":"3139,3140,3141,3142","sell_price":35,"market_price":0,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":274,"list_img":"goodsimg/1497070382948.jpg?imageMogr2/thumbnail/400x400!","name":"婴幼儿初榨 核桃油DHA","memo":"","parent_id":"3139,3140,3141,3142","sell_price":188,"market_price":188,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":346,"list_img":"goodsimg/1499693957021.jpg?imageMogr2/thumbnail/400x400!","name":"芦笋","memo":"","parent_id":"3139,3140,3141,3142","sell_price":1,"market_price":1,"is_friday":1,"distribution_type":4,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":362,"list_img":"goodsimg/1501146314989.jpg?imageMogr2/thumbnail/400x400!","name":"可口可乐","memo":"","parent_id":"","sell_price":3,"market_price":3.5,"is_friday":1,"distribution_type":3,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":375,"list_img":"goodsimg/1501406782517.jpg?imageMogr2/thumbnail/400x400!","name":"油麦菜","memo":"","parent_id":"","sell_price":1,"market_price":0,"is_friday":1,"distribution_type":3,"type":1,"spec_array":[],"is_sell":1,"is_spec":0},{"id":409,"list_img":"goodsimg/1501503047759.jpg?imageMogr2/thumbnail/400x400!","name":"小米椒","memo":"","parent_id":"","sell_price":1,"market_price":0,"is_friday":2,"distribution_type":1,"type":1,"spec_array":[],"is_sell":1,"is_spec":0}]
         * friday : {"date":"2017/08/04 00:00:00","type":1,"sun":205930}
         */

        private ChaojiBean chaoji;
        private FridayBean friday;
        private List<BannerBean> banner;
        private List<ActivityBean> activity;
        private List<HuodongBean> huodong;
        private List<GoodsBean> goods;

        public ChaojiBean getChaoji() {
            return chaoji;
        }

        public void setChaoji(ChaojiBean chaoji) {
            this.chaoji = chaoji;
        }

        public FridayBean getFriday() {
            return friday;
        }

        public void setFriday(FridayBean friday) {
            this.friday = friday;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<ActivityBean> getActivity() {
            return activity;
        }

        public void setActivity(List<ActivityBean> activity) {
            this.activity = activity;
        }

        public List<HuodongBean> getHuodong() {
            return huodong;
        }

        public void setHuodong(List<HuodongBean> huodong) {
            this.huodong = huodong;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class ChaojiBean {
            /**
             * id : 45
             * type : 2
             * img : goodsimg/1500723901773.jpg
             * url : 257
             * is_alone : 1
             */

            private String id;
            private String type;
            private String img;
            private String url;
            private String is_alone;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getIs_alone() {
                return is_alone;
            }

            public void setIs_alone(String is_alone) {
                this.is_alone = is_alone;
            }
        }

        public static class FridayBean {
            /**
             * date : 2017/08/04 00:00:00
             * type : 1
             * sun : 205930
             */

            private String date;
            private String type;
            private String sun;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSun() {
                return sun;
            }

            public void setSun(String sun) {
                this.sun = sun;
            }
        }

        public static class BannerBean {
            /**
             * id : 71
             * type : 5
             * img : goodsimg/1496742097579.jpg
             * url : 2
             * is_alone : 1
             */

            private String id;
            private String type;
            private String img;
            private String url;
            private String is_alone;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getIs_alone() {
                return is_alone;
            }

            public void setIs_alone(String is_alone) {
                this.is_alone = is_alone;
            }
        }

        public static class ActivityBean {
            /**
             * id : 7
             * title : 生鲜美食
             * content : 
             * type : 1
             * goods_ids : 260,262,263
             * memo : 甄选全球食材，安心之选，爱上下厨
             * sort : 0
             * images : goodsimg/1498792918776.jpg
             * stop_time : 2018-01-03 23:59:00
             * start_time : 2017-06-27 00:00:00
             * is_del : 1
             * contents : <p>00&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;</p>
             * created_at : 2016-11-01 09:30:50
             * updated_at : 2017-06-30 14:11:02
             * type_id : 206
             * list : [{"id":260,"list_img":"goodsimg/1496912693470.jpg?imageMogr2/thumbnail/400x400!","name":"黑加仑葡萄干","sell_price":20,"type":1,"spec_array":[]},{"id":263,"list_img":"goodsimg/1496912828734.jpg?imageMogr2/thumbnail/400x400!","name":"纸皮巴旦木","sell_price":80,"type":1,"spec_array":[]}]
             */

            private String id;
            private String title;
            private String content;
            private String type;
            private String goods_ids;
            private String memo;
            private String sort;
            private String images;
            private String stop_time;
            private String start_time;
            private String is_del;
            private String contents;
            private String created_at;
            private String updated_at;
            private String type_id;
            private List<ListBean> list;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getGoods_ids() {
                return goods_ids;
            }

            public void setGoods_ids(String goods_ids) {
                this.goods_ids = goods_ids;
            }

            public String getMemo() {
                return memo;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getStop_time() {
                return stop_time;
            }

            public void setStop_time(String stop_time) {
                this.stop_time = stop_time;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getIs_del() {
                return is_del;
            }

            public void setIs_del(String is_del) {
                this.is_del = is_del;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getType_id() {
                return type_id;
            }

            public void setType_id(String type_id) {
                this.type_id = type_id;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * id : 260
                 * list_img : goodsimg/1496912693470.jpg?imageMogr2/thumbnail/400x400!
                 * name : 黑加仑葡萄干
                 * sell_price : 20
                 * type : 1
                 * spec_array : []
                 */

                private String id;
                private String list_img;
                private String name;
                private String sell_price;
                private String type;
                private List<?> spec_array;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getList_img() {
                    return list_img;
                }

                public void setList_img(String list_img) {
                    this.list_img = list_img;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getSell_price() {
                    return sell_price;
                }

                public void setSell_price(String sell_price) {
                    this.sell_price = sell_price;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public List<?> getSpec_array() {
                    return spec_array;
                }

                public void setSpec_array(List<?> spec_array) {
                    this.spec_array = spec_array;
                }
            }
        }

        public static class HuodongBean {
            /**
             * id : 25
             * type : 3
             * img : goodsimg/1478771708459.jpg
             * url : 8
             * is_alone : 1
             */

            private String id;
            private String type;
            private String img;
            private String url;
            private String is_alone;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getIs_alone() {
                return is_alone;
            }

            public void setIs_alone(String is_alone) {
                this.is_alone = is_alone;
            }
        }

        public static class GoodsBean {
            /**
             * id : 183
             * list_img : goodsimg/1496893433651.jpg?imageMogr2/thumbnail/400x400!
             * name : 枫叶棒棒糖
             * memo : 
             * parent_id : 3139,3140,3141,3142
             * sell_price : 18
             * market_price : 18
             * is_friday : 1
             * distribution_type : 4
             * type : 1
             * spec_array : []
             * is_sell : 1
             * is_spec : 0
             */

            private String id;
            private String list_img;
            private String name;
            private String memo;
            private String parent_id;
            private String sell_price;
            private String market_price;
            private String is_friday;
            private String distribution_type;
            private String type;
            private String is_sell;
            private String is_spec;
            private List<?> spec_array;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getList_img() {
                return list_img;
            }

            public void setList_img(String list_img) {
                this.list_img = list_img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMemo() {
                return memo;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public String getParent_id() {
                return parent_id;
            }

            public void setParent_id(String parent_id) {
                this.parent_id = parent_id;
            }

            public String getSell_price() {
                return sell_price;
            }

            public void setSell_price(String sell_price) {
                this.sell_price = sell_price;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getIs_friday() {
                return is_friday;
            }

            public void setIs_friday(String is_friday) {
                this.is_friday = is_friday;
            }

            public String getDistribution_type() {
                return distribution_type;
            }

            public void setDistribution_type(String distribution_type) {
                this.distribution_type = distribution_type;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getIs_sell() {
                return is_sell;
            }

            public void setIs_sell(String is_sell) {
                this.is_sell = is_sell;
            }

            public String getIs_spec() {
                return is_spec;
            }

            public void setIs_spec(String is_spec) {
                this.is_spec = is_spec;
            }

            public List<?> getSpec_array() {
                return spec_array;
            }

            public void setSpec_array(List<?> spec_array) {
                this.spec_array = spec_array;
            }
        }
    }
}
