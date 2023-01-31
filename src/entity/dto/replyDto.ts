import {GetReplyPageVo} from "@/entity/vo/replyVo";

/**
 * replyTable显示数据
 */
export interface ReplyTableShowDto extends GetReplyPageVo {
    matchTypeShow: string;
    enableShow: string;
    ignoreCaseShow: string;
    ignoreDbcShow: string;
}

