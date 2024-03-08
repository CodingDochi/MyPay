package tutorial.membership.application.port.out.query;

import tutorial.membership.domain.Membership;

public interface FindMembershipPort {
    Membership findMembership(
            Membership.MembershipId membershipId
    );
}
