package tutorial.membership.application.port.out.query;

import tutorial.membership.domain.Membership;

public interface UpdateMembershipPort {

    Membership updateMembership(
            Membership.MembershipId membershipId,
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid
    );
}
