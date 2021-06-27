package com.guanting.common.constant;

/**

 * Created by maochengcheng on 2020/2/7.
 */
public class Constant {

    /**
     * 人员标记
     */
    public final static String RYBJ = "rybj";

    /**
     * 在押人员类别
     */
    public class zyrylb {
        /**
         * 在押嫌疑人
         */
        public final static String zyxyr = "在押嫌疑人";
        /**
         * 在押嫌疑人代码
         */
        public final static String zyxyrdm = "01";
        /**
         * 留所服刑犯
         */
        public final static String lsfxf = "留所服刑犯";
        /**
         * 留所服刑犯代码
         */
        public final static String lsfxfdm = "00";

    }

    /**
     * 人员标记
     */
    public class rybj {
        /**
         * 在押
         */
        public final static String zy = "0";
        /**
         * 历史
         */
        public final static String ls = "1";
        /**
         * 预收押
         */
        public final static String ysy = "5";
        /**
         * 预收押删除（拒收）
         */
        public final static String ysysc = "8";
        /**
         * 删除
         */
        public final static String sc = "9";
    }

    /**
     * 复议阶段
     */
    public class fyjd {
        // 复议申请
        public final static String fysq = "复议申请";
        // 复议申请代码
        public final static String fysqdm = "0";
        // 评定通过
        public final static String pdtg = "评定通过";
        // 评定通过代码
        public final static String pdtgdm = "1";
        // 评定不通过
        public final static String pdbtg = "评定不通过";
        // 评定不通过代码
        public final static String pdbtgdm = "2";
    }

    /**
     * 考核分值类型
     */
    public class khfzlx {
        // 加分
        public final static String jiafen = "01";
        // 扣分
        public final static String kf = "02";
        // 奖分
        public final static String jiangfen = "03";
    }

    /**
     * 办案单位类型
     */
    public class badwlxdm {
        // 公安机关
        public final static String gajg = "1";
        // 检察院
        public final static String jcy = "2";
        // 法院
        public final static String fy = "3";
    }

    /**
     * 入所原因
     */
    public class rsyydm {
        // 异地羁押
        public final static String ydjy = "16";
        // 临时寄押
        public final static String lsjy = "13";
    }

    /**
     * 性别
     */
    public class sex {
        // 男
        public final static String male = "1";
        // 女
        public final static String female = "2";
    }

    /**
     * 身份核查结果
     */
    public class sfhcbz {
        /* 未核查 */
        public final static String whc = "0";
        /* 已核查 */
        public final static String yhc = "1";
    }

    /**
     * 诉讼阶段状态
     */
    public class ssjdzt {
        /* 已决 */
        public final static String yj = "36";
        public final static String yjhz = "已决";

        /*待执行*/
        public final static String dzx = "35";
        public final static String dzxhz = "待执行";

        /*刑事拘留*/
        public final static String xsjl = "11";

    }


    /*诉讼阶段*/
    public static String ssjd = "诉讼阶段";

    public static final String ajlb = "案件类别";

    public static final String xb = "性别";

    public static final String mz = "民族";

    public static final String gj = "国籍";

    public static final String jg = "籍贯";

    public static final String zzmm = "政治面貌";

    public static final String zjlx = "证件类型";

    public static final String zy = "职业";

    public static final String zc = "专长";

    public static final String zw = "职务";

    public static final String wxdj = "人员危险等级";

    public static final String zwjb = "干部职务级别";

    public static final String jx = "警衔";

    public static final String xq = "刑期代码";

    public static final String hyzk = "婚姻状况";

    public static final String rygllb = "人员管理类别";

    public static final String wffzjl = "违法犯罪经历";

    public static final String whcd = "文化程度";

    public static final String whcd1 = "文化程度";

    public static final String sf = "身份";

    public static final String sfhcjgmc = "身份核查结果";

    public static final String tssf = "在押特殊身份";

    public static final String cylb = "成员类型";

    public static final String xzqh = "行政区划";

    public static final String rsyy = "入所原因";

    public static final String csyy = "出所原因";

    public static final String csqx = "出所去向";

    public static final String sypz = "收押凭证";

    public static final String badw = "办案单位";

    public static final String badwlx = "办案单位类型";

    public static final String badwbzdm = "办案单位标准代码";

    public static final String pjzm = "判决罪名";

    public static final String mjzwxx = "民警职务信息";

    public static final String jslx = "监室类型";

    public static final String JQLX = "监区类型";

    public static final String yplx = "药品类型";

    public static final String ypdw = "药品单位";

    public static final String yycs = "用药次数";

    public static final String lscsyy = "临时出所原因";


    public static final String ishandle = "是否处理";

    public static final String fjx = "附加刑";

    public static final String zyhxxq = "在押缓刑刑期";

    public static final String zylsyy = "在押留所原因";

    public static final String lxjpp = "录像机品牌";

    public static final String jbzd = "疾病诊断";

    /**
     * 发药次数
     */
    public static final String FYCS = "发药次数";

    /**
     * 剂量单位
     */
    public static final String JLDW = "剂量单位";

    /*在押谈话类型*/
    public static String zythlx = "在押谈话类型";
    /**
     * 延期原因
     */
    public static final String yqyy = "延期原因";

    public static final String qrgz = "七日跟踪";

    public static class zythlxClass {
        public static final String RSESXSTH = "01";
        public static final String RSESXSTHMC = "入所24小时谈话";
        public static final String ZDRYTH = "02";
        public static final String ZDRYTHMC = "重点人员谈话";
        public static final String MYYCTH = "03";
        public static final String MYYCTHMC = "每月一次谈话";
        public static final String SWFZTH = "04";
        public static final String SWFZTHMC = "深挖犯罪谈话";
        public static final String ZDYQTH = "05";
        public static final String ZDYQTHMC = "主动要求谈话";
        public static final String WGHCFQH = "06";
        public static final String WGHCFQHMC = "违规或被处罚前后";
        public static final String EMKH = "07";
        public static final String EMKHMC = "耳目考核";
        public static final String DBTH = "08";
        public static final String DBTHMC = "逮捕谈话";
        public static final String QSTH = "09";
        public static final String QSTHMC = "起诉谈话";
        public static final String PJTH = "10";
        public static final String PJTHMC = "判决谈话";
        public static final String QTSSHJBD = "11";
        public static final String QTSSHJBDMC = "其他诉讼环节变动";
        public static final String TJHTH = "12";
        public static final String TJHTHMC = "调监后谈话";
        public static final String LSJY = "13";
        public static final String LSJYMC = "离所教育";
        public static final String LSHJHESSXS = "14";
        public static final String LSHJHESSXSMC = "律师会见后24小时";
        public static final String SCQS = "15";
        public static final String SCQSMC = "审查起诉一";
        public static final String XXYTH = "16";
        public static final String XXYTHMC = "信息员谈话";
        public static final String TXHTH = "17";
        public static final String TXHTHMC = "提询后谈话";
        public static final String LSHJHTH = "18";
        public static final String LSHJHTHMC = "律师会见后谈话";
        public static final String QSTFHTH = "19";
        public static final String QSTFHTHMC = "亲属探访后谈话";
        public static final String QJHSTH = "20";
        public static final String QJHSTHMC = "请假回所谈话";
        public static final String YQFYJSDT = "21";
        public static final String YQFYJSDTMC = "要求反映戒室动态";
        public static final String QXBWXWFC = "22";
        public static final String QXBWXWFCMC = "情绪不稳行为反常";
        public static final String JTCXBG = "23";
        public static final String JTCXBGMC = "家庭出现变故";
        public static final String CSQTH = "24";
        public static final String CSQTHMC = "出所前谈话";
        public static final String XZTH = "25";
        public static final String XZTHMC = "下组谈话";
        public static final String XSTH = "26";
        public static final String XSTHMC = "线索谈话";
        public static final String RQGZTH = "27";
        public static final String RQGZTHMC = "七天跟踪教育";
        public static final String QTTH = "99";
        public static final String QTTHMC = "其他谈话";
    }

    public static final String jkzk = "健康状况";

    public static final String ysyj = "医生意见";

    public static final String cljg = "处理结果";

    public static final String wg = "违规";

    /**
     * 预约处理结果
     */
    public class yycljg {
        //拒绝
        public static final String jj = "0";
        public static final String jjhz = "拒绝";
        //同意
        public static final String ty = "1";
        public static final String tyhz = "已同意";
    }

    /**
     * 三大刑
     */
    public class sdx {
        /**
         * 死刑
         */
        public static final String sx = "107";

        /**
         * 死缓
         */
        public static final String sh = "106";

        /**
         * 无期
         */
        public static final String wq = "104";
    }

    /**
     * 在押违规等级
     */
    public static final String ZYWGDJ = "在押违规等级";

    /**
     * 械具类别
     */
    public static final String XJLB = "械具类别";

    /**
     * 在押违规等级 code
     */
    public class zywgdj {
        /*轻微违规*/
        public static final String qwwg = "1";

        /*一般违规*/
        public static final String ybwg = "2";

        /*严重违规*/
        public static final String yzwg = "3";
    }

    /**
     * 跟踪类型
     */
    public static final String GZLX = "跟踪类型";

    /**
     * 提讯会见状态
     */
    public static final String TXHJZT = "提讯会见状态";


    public class txzt {
        /*收证*/
        public static final String sz = "1";

        /*批量收证*/
        public static final String plsz = "2";

        /*提出*/
        public static final String tc = "3";


        /*排队中*/
        public static final String zztx = "4";

        /*结束*/
        public static final String js = "5";

        /*提回*/
        public static final String th = "7";

        /*退证*/
        public static final String tz = "9";

        /*待会见*/
        public final static String dhj = "0";
    }

    /**
     * 家属会见状态
     */
    public static final String JSHJZT = "家属会见状态";

    public class jshj {
        /*收证*/
        public static final String sz = "1";

        /*批量收证*/
        public static final String plsz = "2";

        /*提出*/
        public static final String tc = "3";

        /*结束*/
        public static final String js = "5";

        /*提回*/
        public static final String th = "7";

        /*退证*/
        public static final String tz = "9";
    }
/*
    public class hjslx {
        *//*提讯会见室*//*
        public static final String txhjs = "1";

        *//*律师会见室*//*
        public static final String lshjs = "2";
    }*/

    /**
     * 会见室状态
     */
    public class hjszt {
        /**
         * 未使用
         */
        public static final String WSY = "0";

        /**
         * 已使用
         */
        public static final String YSY = "1";
    }


    public static final String lsdw = "律师单位";

    /*律师会见状态  和提讯会见的状态一致*/
    public class lshjzt {
        /* 待提出(收证) */
        public final static String dtc = "1";
        /*批量收证*/
        public static final String plsz = "2";
        /* 待结束(提出) */
        public final static String djs = "3";
        /* 待提回 (结束)*/
        public final static String dth = "5";
        /* 待退证 (提回)*/
        public final static String dtz = "7";
        /* 会见结束 (退证)*/
        public final static String hjjs = "9";
        /*待会见*/
        public final static String dhj = "0";
    }

    /**
     * 会见室类型
     */
    public class hjslx {
        /* 提讯会见室 */
        public final static String TXHJS = "1";
        /* 律师会见室 */
        public final static String lshjs = "2";
        /* 家属会见室*/
        public final static String JSHJS = "3";
        /* 谈话室 */
        public final static String THJYS = "4";
    }

    /*律师委托状态*/
    public class lswtzt {
        /* 解除委托 */
        public final static String jcwt = "0";
        /* 正在委托 */
        public final static String zzwt = "1";
    }

    /* 储物柜类型 */
    public class cwglx {
        /* 物品保管柜 */
        public final static String wpbgg = "1";
    }

    /* 储物柜使用状态 */
    public class cwgsyzt {
        /* 未使用 */
        public final static String wsy = "0";
    }

    public static final String fxdj = "在押风险等级";

    public static final String ZYFXDJ = "在押风险等级";

    /* 在押风险等级 */
    public class zyfxdj {
        /*一级 */
        public final static String yjfx = "A";
        /*二级 */
        public final static String ejfx = "B";
        /*三级 */
        public final static String sjfx = "C";
        /*一般风险*/
        public final static String ybfx = "D";
        /*未评估*/
        public final static String wpg = "E";
    }

    /**
     * 单独关押（禁闭状态）
     */
    public static class jbzt {
        /**
         * 单独关押申请
         */
        public static final Short SQ = 1;

        /**
         * 单独关押医生意见
         */
        public static final Short YJ = 2;

        /**
         * 单独关押审批
         */
        public static final Short SP = 3;

        /**
         * 单独关押执行
         */
        public static final Short ZX = 4;

        /**
         * 单独关押解除
         */
        public static final Short JC = 5;

        /**
         * 单独关押撤销
         */
        public static final Short CX = 6;

        /**
         * 禁闭审批不通过
         */
        public static final Short SPBTG = 7;

        /**
         * 禁闭审批通过
         */
        public static final Short SPTG = 8;
    }

    /**
     * 禁闭流程状态
     */
    public static class jblczt {
        /**
         * 待审批（申请）
         */
        public static final int DSP = 0;

        /**
         * 撤销申请
         */
        public static final int CXSQ = 5;

        /**
         * 已审批（待执行）
         */
        public static final int YSP = 2;

        /**
         * 正在执行（待解除）
         */
        public static final int ZZZX = 3;

        /**
         * 已解除
         */
        public static final int YJC = 1;

        /*医生意见*/
        public final static int YSYJ = 6;
    }

    /**
     * 所外就医状态
     */
    public class swjyzt {
        /**
         * 待审批
         */
        public final static int dsp = 0;
        /**
         * 审批通过
         */
        public final static int sptg = 1;
        /**
         * 审批未通过
         */
        public final static int spwtg = 2;
        /**
         * 3出所就医
         */
        public final static int csjy = 3;
        /**
         * 4已回所
         */
        public final static int yhs = 4;
        /**
         * 5申请撤销
         */
        public final static int sqcs = 5;
    }

    /**
     * 械具状态
     */
    public class xjzt {
        /**
         * 待审批
         */
        public final static int dsp = 0;
        /**
         * 审批通过
         */
        public final static int sptg = 1;
        /**
         * 审批未通过
         */
        public final static int spwtg = 2;
        /**
         * 已使用
         */
        public final static int ysy = 3;
        /**
         * 已解除
         */
        public final static int yjc = 4;
        /**
         * 5申请撤销
         */
        public final static int sqcs = 5;
        /*医生意见*/
        public final static int ysyj = 6;

    }

    /**
     * 审批意见
     */
    public class spyj {
        /**
         * 待审
         */
        public final static String ds = "0";
        /**
         * 同意
         */
        public final static String ty = "1";
        /**
         * 不同意
         */
        public final static String bty = "2";
        /**
         * 退回
         */
        public final static String th = "9";
    }

    /**
     * 投送状态
     */
    public class tszt {
        /**
         * 待投送
         */
        public final static int dts = 1;
        /**
         * 已投送
         */
        public final static int yts = 2;
        /**
         * 撤销投送
         */
        public final static int cxts = 3;
    }

    /**
     * 严管人员考核状态
     */
    public class khzt {
        /**
         * 待审批
         */
        public final static String dsp = "0";
        /**
         * 审批通过
         */
        public final static String sptg = "1";
        /**
         * 审批未通过
         */
        public final static String spwtg = "2";
        /**
         * 撤管
         */
        public final static String cg = "3";
        /**
         * 申请撤销
         */
        public final static String sqcx = "4";
    }

    /**
     * 账户状态
     */
    public static class AccountStatus {
        /**
         * 正常
         */
        public final static String NORMAL = "1";
        /**
         * 挂失
         */
        public final static String REPORT_THE_LOSS = "2";
        /**
         * 冻结
         */
        public final static String FROZEN = "3";
        /**
         * 销户
         */
        public final static String SALES_ACCOUNT = "4";
        /**
         * 退款
         */
        public final static String REFUND = "5";
    }

    public static class swyylx {
        public final static String breakfast = "breakfast";

        public final static String lunch = "lunch";

        public final static String dinner = "dinner";
    }

    //执行状态
    public static class zxzt {
        /*待审批*/
        public final static String pendingApproval = "0";
        public final static String pendingApprovalMc = "待审批";
        /*已解除*/
        public final static String relieved = "1";
        public final static String relievedMc = "已解除";
        /*已审批*/
        public final static String approved = "2";
        public final static String approvedMc = "已审批";
        /*正执行*/
        public final static String positiveExecution = "3";
        public final static String positiveExecutionMc = "正执行";
        /*科室已审批*/
        public final static String departmentsHaveBeenApproved = "4";
        public final static String departmentsHaveBeenApprovedMc = "科室已审批";
    }


    public static String udpReceivePort = "";
    public static String udpSendPort = "";

    /* 考评管理 */
    public static class kpgl {
        public static String ASSESSMENT_OF_DETAINEES = "1";// 在押人员考评
        public static String POLICE_EVALUATION = "2";// 民警考评
        public static String EVIEW_AND_REVIEW = "3";// 监室考评
    }


    /**
     * 重点监管人员状态
     */
    public static class zdjgryzt {
        /**
         * 已申请
         */
        public final static String ysq = "1";
        /**
         * 撤销申请
         */
        public final static String cxsq = "2";
        /**
         * 审批通过
         */
        public final static String sptg = "3";
        /**
         * 审批未通过
         */
        public final static String spwtg = "4";
        /**
         * 待撤销
         */
        public final static String dcx = "5";
        /**
         * 已撤销
         */
        public final static String ycx = "6";
    }

    /*预约人员类型*/
    public static class yyrylx {
        /**
         * 1：管教
         */
        public final static String gj = "1";
        public final static String GJHZ = "预约管教";
        /**
         * 2：所长
         */
        public final static String sz = "2";
        public final static String SZHZ = "预约所长";
        /**
         * 3：检察官
         */
        public final static String jcg = "3";
        public final static String JCGHZ = "预约检察官";
        /**
         * 4：医生
         */
        public final static String ys = "4";
        public final static String YSHZ = "预约医生";
        /**
         * 5：律师
         */
        public final static String ls = "5";
        public final static String LSHZ = "预约律师";
        /**
         * 6：家属
         */
        public final static String js = "6";
        public final static String JSHZ = "预约家属";
    }

    /**
     * 预约处理状态
     */
    public class clzt {
        /**
         * 未处理
         */
        public static final String WCL = "0";
        /**
         * 已处理
         */
        public static final String YCL = "1";
        public static final String YCLHZ = "已处理";
    }

    /**
     * 性别
     */
    public class Xb {
        public static final String 男 = "1";
        public static final String 女 = "2";
    }

    /**
     * 物品送收标记
     */
    public class wpssbj {
        /* 家属送物 */
        public final static String jssw = "0";
        /* 在押人员收物 */
        public final static String zyrysw = "1";
    }


    /*在押人员病情等级*/
    public class zyrybqdj {
        /* 危重 */
        public final static String critical = "1";
        /* 传染 */
        public final static String contagion = "2";
        /* 一般 */
        public final static String commonly = "9";
    }

    /*跟踪类型*/
    public class gzlxxq {
        /* 新入所 */
        public final static String newEntry = "1";
        /* 重大风险 */
        public final static String majorRisks = "2";
        /* 单独关押 */
        public final static String solitaryConfinement = "3";
        /* 重点病患 */
        public final static String keyPatients = "4";
        /* 夹带械具 */
        public final static String entrainmentEquipment = "5";
        /* 其他 */
        public final static String other = "6";
    }

    /**
     * 外出状态
     */
    public class wczt {
        /*外出*/
        public final static int wc = 1;
        /*送回*/
        public final static int sh = 2;
        /*待出所*/
        public final static int dcs = 3;
    }

    /**
     * 医嘱类型
     */
    public class yzlx {
        /*长期医嘱停止1*/
        public final static String cqyztz = "0";
        /*长期医嘱*/
        public final static String cqyz = "1";
        /*临时医嘱*/
        public final static String lsyz = "2";
    }

    /*人员状态*/
    public class ryzt {
        /*稳定*/
        public final static String WD = "001";
        public final static String WDHZ = "稳定";
        /*基本稳定*/
        public final static String JBWD = "002";
        public final static String JBWDHZ = "基本稳定";
        /*不稳定*/
        public final static String BWD = "003";
        public final static String BWDHZ = "不稳定";
        /*重点关注人员*/
        public final static String ZDGZRY = "004";
        public final static String ZDGZRYHZ = "重点关注人员";
    }

    /**
     * 就医情况
     */
    public class jyqk {
        public final static String BYZZ = "病因症状";
        public final static String ZLCS = "治疗措施";
        public final static String ZLXG = "治疗效果";
        public final static String YPLB = "戒毒药品类别";
        public final static String YPJX = "戒毒药品剂型";
        public final static String YPDW = "戒毒药品单位";
    }

    /*评判结果*/
    public class ppjg {
        /*表现正常*/
        public final static String BXZC = "001";
        public final static String BXZCHZ = "表现正常";
        /*表现不正常*/
        public final static String BXBZC = "002";
        public final static String BXBZCHZ = "表现不正常";
    }

    /*打架行为*/
    public class djxw {
        /*无*/
        public final static String WU = "01";
        /*有*/
        public final static String YOU = "02";
    }

    /*过激行为*/
    public class gjxw {
        /*无*/
        public final static String WU = "01";
        /*有*/
        public final static String YOU = "02";
    }

    /*警情类型*/
    public class jqlx {
        /*管教岗位评定*/
        public final static String GJGW = "1";
        public final static String GJGWHZ = "管教岗位评定";
        /*医生岗位评定*/
        public final static String YWGW = "2";
        public final static String YWGWHZ = "医生岗位评定";
    }

    /*评判类型*/
    public class pplx {
        /*无*/
        public final static String XKPP = "巡控评判";
        /*有*/
        public final static String LDPP = "领导评判";
    }

    /*评价等级（监室）*/
    public class pjdj {
        /*优*/
        public final static String you = "0";
        /*良*/
        public final static String liang = "1";
        /*中*/
        public final static String zhong = "2";
        /*差*/
        public final static String cha = "3";

    }

    /**
     * 人员所内状态
     */
    public class snzt {
        /**
         * 无状态
         */
        public final static String WZT = "0";
        /**
         * 律师会见状态
         */
        public final static String LSHJZT = "4";
        /**
         * 提讯会见状态
         */
        public final static String TXHJZT = "1";
        /**
         * 禁闭状态
         */
        public final static String JBZT = "7";
        /**
         * 临时出所状态
         */
        public final static String LSCSZT = "6";
        /**
         * 提押状态
         */
        public final static String TYZT = "2";
        /**
         * 所外就医状态
         */
        public final static String SWJYZT = "3";

        /**
         * 家属会见
         */
        public final static String JSHJZT = "5";
    }

    /*消息类型*/
    public class MessageType {
        /*待办消息*/
        public final static String DAIBAN = "1";
        /*个人消息*/
        public final static String GEREN = "2";
        /*警情通知*/
        public final static String JINGQING = "3";
        /*总队通知*/
        public final static String ZDTZ = "4";

    }

    /*消息处理状态*/
    public class MessageClzt {
        /*未处理*/
        public final static String WCL = "0";
        /*已处理*/
        public final static String YCL = "1";
    }

    /*消息已读状态*/
    public class MessageStatus {
        /*未处理*/
        public final static String WD = "0";
        /*已处理*/
        public final static String YD = "1";
    }


    /**
     * 充值审核状态
     */
    public class shzt {
        //已申请
        public final static String ysq = "0";
    }

    /**
     * 代购商品订单状态
     */
    public class Ddzt {
        //已下单
        public final static String YXD = "1";
        //已出货
        public final static String YCH = "2";
        //确认收货
        public final static String QRSH = "3";
        //撤销
        public final static String CX = "4";
        //待审核
        public final static String DSH = "0";
    }

    /**
     * 诉讼阶段
     */
    public class ssjdCode {
        //逮捕
        public final static String DB = "12";
        //刑事拘留
        public final static String XSJU = "11";

        //待执行
        public final static String DZX = "35";
        //已决
        public final static String YJ = "36";

        // 审查起诉(1)
        public final static String SCQS1 = "21";
        //审查起诉(2)
        public final static String SCQS2 = "22";
        // 审查起诉(3)
        public final static String SCQS3 = "23";

        //一审
        public final static String YS = "31";
        //  二审
        public final static String ES = "32";

        //死刑复核
        public final static String SXFH = "34";

        //公安补充侦查(1)
        public final static String GABCZC1 = "13";
        //公安补充侦查(2)
        public final static String GABCZC2 = "14";

        //检察补充侦查
        public final static String JCBCZC = "24";

        // 发回重审
        public final static String FHCS = "33";

        //其他
        public final static String QT = "99";

    }

    /**
     * 库存变动表 记录类型
     * 1.进货记录2、损耗记录、3.撤销进货记录、4.消费记录
     */
    public class kcbdJllx {
        //进货
        public final static String JHCZJL = "1";
        public final static String SHJL = "2";
        public final static String CXJHJL = "3";
        public final static String XFJL = "4";
    }

    /**
     * 图片资源文件夹名称
     * <p>
     * 物品保管：wpbg  code 0
     * 在押人员照片：personPic code 1
     * 健康检查照片：jkjcPic code 2
     * 伤情登记照片：sqdjPic code 3
     * 医疗检查电子档案：yldzjcPic code 4
     * 工作人员照片：policePic code 5
     * 在押人员指纹照片： personFingerPic code 6
     * 工作人员指纹照片： policeFingerPic code 7
     * 自助提审人员人脸照片  zztsrlPic    code 8
     * 自助提审人员注册照片  zztszcPic    code 9
     * 协助破案照片： xzpaPic code 10
     * 政法一体化文书：zfythWs
     * 不够继续完善
     */
    public class picPath {
        public final static String wpbg = "wpbg/";
        public final static String personPic = "personPic/";
        public final static String jkjcPic = "jkjcPic/";
        public final static String sqdjPic = "sqdjPic/";
        public final static String yldzjcPic = "yldzjcPic/";
        public final static String policePic = "policePic/";
        public final static String personFingerPic = "personFingerPic/";
        public final static String policeFingerPic = "policeFingerPic/";
        public final static String zztsrlPic = "zztsrlPic/";
        public final static String zztszcPic = "zztszcPic/";
        public final static String xzpaPic = "xzpaPic/";
        public final static String zfythWs = "zfythWs/";
        public final static String jsswPic = "jsswPic/";
        public final static String xjsfPic = "xjsfPic/";
    }

    /**
     * 就医类型
     */
    public class jylx {
        public final static String code1 = "1";
        public final static String code2 = "2";
        public final static String code3 = "3";

        public final static String item1 = "巡诊就医";
        public final static String item2 = "门诊就医";
        public final static String item3 = "报告处置";
    }

    /**
     * 械具使用表内 使用原因
     */
    public final static String jjsyyy = "戒具使用原因";

    /**
     * 考评内容
     */
    public class kpnr {
        public final static String XXXL = "学习训练";
        public final static String XWGF = "行为规范";
        public final static String SHWS = "生活卫生";
        public final static String RZHZ = "认罪悔罪";
        public final static String ZSGD = "遵守规定";
        public final static String JSJY = "接受教育";
        public final static String CJLD = "参加劳动";
        public final static String ZXKF = "专项扣分";
        public final static String ZXJF = "专项加分";
    }

    /*考核审核*/
    public final static String KHSHH = "考核审核";

    /**
     * 考核审核
     */
    public class khsh {
        /*待审核*/
        public final static String DSH = "0";
        /*审核通过*/
        public final static String SHTG = "1";
        /*审核未通过*/
        public final static String SHWTG = "2";
        /*投送未收*/
        public final static String TSWS = "3";
    }

    /**
     * 定时点名状态
     */
    public class dmzt {
        /*停用*/
        public final static String TY = "0";
        /*启用*/
        public final static String QY = "1";
    }

    /**
     * 民族
     */
    public class mzcode {
        /*汉族*/
        public final static String HZ = "01";
    }

    /**
     * 国籍
     */
    public class gjcode {
        /*中国*/
        public final static String CHINA = "156";
        /*中国台湾*/
        public final static String TAIWANDAO = "158";
    }

    /**
     * 疾病症状状态
     */
    public class jbzdCode {
        /*艾滋病*/
        public final static String AZB = "06001";
    }

    /**
     * 餐别
     */
    public final static String CB = "餐别";


    /**
     * 自助提审注册类型
     */
    public class zztslx {

        /*公安*/
        public final static String ga = "0";
        /*律师*/
        public final static String ls = "1";
        /*检察院*/
        public final static String jcy = "2";
        /*法院*/
        public final static String fy = "3";

        /*未知类型*/
        public final static String unknow = "unknow";
    }


    /**
     * 自助提审注册类型
     */
    public class zztslxstr {

        /*公安*/
        public final static String ga = "公安";
        /*律师*/
        public final static String ls = "律师";
        /*检察院*/
        public final static String jcy = "检察院";
        /*法院*/
        public final static String fy = "法院";

        /*未知类型*/
        public final static String unknow = "unknow";
    }

    public final static String zwFuffix = ".png";

    public final static String ZYRYSNZT = "所内状态";


    /**
     * 自助提审工作时间
     */
    public class workhour {

        /*上午上班时间*/
        public final static String startAm = "8";

        /*上午下班时间*/
        public final static String endAm = "12";

        /*下午上班时间*/
        public final static String startPm = "14";

        /*下午下班时间*/
        public final static String endPm = "23";


    }


    /**
     * 预约家属处理状态
     */
    public class yyjsClzt {
        /**
         * 未处理
         */
        public static final String wcl = "0";
        /**
         * 同意
         */
        public static final String yty = "1";
        /**
         * 不同意
         */
        public static final String bty = "2";
    }

    /**
     * 不被过滤的照片url里面的参数code
     */
    public class NoFileCodes {

        /*人脸*/
        public static final String rl = "8";

        /*注册照片*/
        public static final String zc = "9";
    }


    public final static String ENSYZXZT = "执行状态";


    /**
     * 耳目审批意见
     */
    public class emsySpyj {

        /**
         * 同意
         */
        public static final String ty = "同意";
        /**
         * 不同意
         */
        public static final String bty = "不同意";
    }

    /**
     * 电源控制定时计划 启用状态
     */
    public class dykzzt {
        /**
         * 定时计划 启动
         */
        public static final String QY = "1";
        /**
         * 定时计划  不启动
         */
        public static final String BQY = "0";
    }


    /**
     * 电源控制-->设备开关
     */
    public class dykzOnOff {
        public static final String ON = "on";
        public static final String OFF = "off";
    }


    /**
     * 报警记录是否处理状态
     */
    public class ishandleMsg {
        //未处理
        public static final String WCL = "0";
        //已处理
        public static final String YCL = "1";
        //已处理过,但被修改过
        public static final String YCLBUTXGG = "2";
    }


    /**
     * 提押事由字典项
     */
    public static final String tysy = "提押事由";

    /**
     * 提解事由
     */
    public static final String tjsy = "提解事由";

    /**
     * 最大排队人数
     */
    public static final String maxPd = "999";

    /**
     * 提讯排队标识
     */
    public static final String txpdbs = "A";

    /**
     * 提解排队标识
     */
    public static final String tjpdbs = "B";

    /**
     * 律师会见排队标识
     */
    public static final String lshjpdbs = "C";

    public class pdzt {

        /**
         * 等待
         */
        public static final String wait = "0";

        /**
         * 办理中
         */
        public static final String handle = "1";

        /**
         * 会见中
         */
        public static final String verify = "2";

        /**
         * 结束
         */
        public static final String end = "3";


    }

    /**
     * 民警审核状态
     */
    public class mjshzt {

        public static final String wait = "待审核";

        public static final String done = "已审核";

        public static final String unknow = "未知状态";

    }

    /**
     * 自助提审排队屏
     */

    public static final String queueSuccess = "1024";


    /**
     * 律师会见动态屏
     */

    public static final String lsdtScreen = "1034";

    /**
     * 提讯会见动态屏
     */

    public static final String txdtScreen = "1044";

    /**
     * 提讯人脸终端
     */

    public static final String txRnScreen = "1045";

    /**
     * 律师会见人脸终端
     */

    public static final String lsRnScreen = "1046";

    /**
     * AB门掌控终端
     */
    public static final String ABdoor = "1014";

    /**
     * 自助提审发送的upd type值
     */
    public class updCode {

        public static final String txQueueDel = "0"; //提讯会见排队删除数据

        public static final String txActionAdd = "1"; //提讯会见动态增加数据

        public static final String txActionDel = "2"; //提讯会见动态删除数据


        public static final String laywerActionAdd = "3"; //律师会见动态增加数据


        public static final String laywerActionDel = "4"; //律师会见动态删除数据


        public static final String queueChange = "5"; //排队状态改变（包括律师会见和提讯、提解）


        public static final String txQueueAdd = "9"; //提讯会见排队增加数据
        public static final String truncateQueue = "6"; //清空提讯排队


        public static final String truncateTxAction = "7"; //清空提讯动态

        public static final String truncateLawyerAction = "8"; //清空律师会见动态


    }

    /**
     * 监管单位类型
     */
    public class jgdwlx {
        //看守所
        public static final String kss = "1";
        //拘留所
        public static final String jls = "2";
        //强制戒毒所
        public static final String jds = "3";
        //收教所
        public static final String sjs = "4";
        //安康医院
        public static final String akyy = "5";
    }

    /**
     * 药房类型
     */
    public class yflx {
        //大药房
        public static final String pharmacy1 = "1";
        //小药房
        public static final String pharmacy2 = "2";
    }

    /**
     * 疾病类别
     */
    public class jblbdm {
        //危重病犯
        public static final String wzbf = "0";
        //传染病犯
        public static final String crbf = "1";
        //重点病犯
        public static final String zdbf = "2";
        //较重点病犯
        public static final String jzdbf = "3";
    }


    public static final String ZHZT = "账户状态";


    /**
     * * 账户信息操作表----> 操作类型
     *
     */
    public class czlx {

        /**
         * 账户充值
         */
        public static final String zhcz = "1";
        /**
         * 账户冲正
         */
        public static final String zhImpact = "2";
        /**
         * 扣款
         */
        public static final String kk = "3";
        /**
         * 提现
         */
        public static final String tx = "4";
        /**
         *  * 退款
         */
        public static final String tk = "5";
        public static final String xh = "6";
        /**
         * 6销户,7消费，8监所费用扣除,9撤销退款）
         */
        public static final String xf = "7";
        public static final String kf = "8";
        public static final String cxtk = "9";
    }


    /**
     * 查询综合配置工具,配置的项目地址,地址类型
     */
    public class dzlx{
        /**
         * 勤务地址
         */
        public static final String qwdz = "1";
        /**
         * 安卓java服务地址
         */
        public static final String azjavadz = "2";
    }


    /*日志操作类型*/
    public class SysLogType{
        /**
         * 新增
         */
        public static final int INSERTDATA = 1;
        /**
         * 删除
         */
        public static final int DELETEDATA = 2;
        /**
         * 修改
         */
        public static final int UPDATEDATA = 3;
        /**
         * 查询
         */
        public static final int SELETEDATA = 4;
    }

    /*首页地址*/
    public class IndexAddress{
        //通用首页
        public static final String TY = "indexPage/portal.7.html";
        //所领导
        public static final String SLD = "indexPage/portal.6.html";
        public static final String SLDCDMC = "所领导";
        //管教
        public static final String GJ = "indexPage/portal.4.html";
        public static final String GJCDMC = "管教岗";
        //新管教页面
        public static final String GJNEW = "gxIndex/index.html";
        public static final String GJNEWCDMC = "管教岗";
        //医务
        public static final String YW = "indexPage/portal.5.html";
        public static final String YWCDMC = "医务岗";
        //巡控
        public static final String XK = "indexPage/portal.3.html";
        public static final String XKCDMC = "巡控岗";

    }


    //在逃人员比对类型
    public class ZtryBdLx{
        //收押比对
        public static final String SYBD = "1";
        //家属会见
        public static final String JSHJBD = "2";
        //家属送物
        public static final String JSSWBD = "3";
        //社会关系
        public static final String SHGXBD = "4";
        //送钱
        public static final String SQ = "5";
    }

}
