package family.dd.member;

import family.dd.entity.UserInfo;

class FamilyMemberRepository {
    private FamilyMemberDAO dao;
    UserInfo[] getUserInfo(String account) {
        return new UserInfo[]{new UserInfo("","")};
    }
    UserInfo[] getUserInfo(int memberId) {
        return new UserInfo[]{new UserInfo("","")};
    }
}
