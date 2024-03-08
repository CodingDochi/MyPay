package tutorial.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

    @Getter private final String id;
    @Getter private final String name;
    @Getter private final String email;
    @Getter private final String address;
    @Getter private final boolean isValid;

    public static Membership generateMember(MembershipId memberId, MembershipName memberName, MembershipEmail memberEmail, MembershipAddress memberAddress, MembershipIsValid memberIsValid){
        return new Membership(memberId.membership_id, memberName.membership_name, memberEmail.membership_email, memberAddress.membership_address, memberIsValid.membership_isValid);
    }

    @Value
    public static class MembershipId {
        String membership_id;
        public MembershipId(String value) {
            this.membership_id = value;
        }
    }

    @Value
    public static class MembershipName {
        String membership_name;
        public MembershipName(String value) {
            this.membership_name = value;
        }
    }

    @Value
    public static class MembershipEmail {
        String membership_email;
        public MembershipEmail(String value) {
            this.membership_email = value;
        }
    }

    @Value
    public static class MembershipAddress {
        String membership_address;
        public MembershipAddress(String value) {
            this.membership_address = value;
        }
    }

    @Value
    public static class MembershipIsValid {
        boolean membership_isValid;
        public MembershipIsValid(boolean value) {
            this.membership_isValid = value;
        }
    }

}
