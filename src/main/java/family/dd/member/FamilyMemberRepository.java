package family.dd.member;

import family.dd.entity.UserInfo;

class FamilyMemberRepository {
    private FamilyMemberDAO dao;
    UserInfo[] getUserInfo(String account, String encryptedPwd) {
        return new UserInfo[]{new UserInfo()};
    }
}
