package tutorial.membership.application.port.out.query;

import tutorial.membership.domain.Membership;

public interface RegisterMembershipPort {

    void createMembership(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid
    );

}
