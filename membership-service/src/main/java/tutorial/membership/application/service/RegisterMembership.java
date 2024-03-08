package tutorial.membership.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import tutorial.common.UseCase;
import tutorial.membership.adapter.out.persistence.MembershipMapper;
import tutorial.membership.application.port.in.RegisterMembershipCommand;
import tutorial.membership.application.port.in.RegisterMembershipUseCase;
import tutorial.membership.application.port.out.query.RegisterMembershipPort;
import tutorial.membership.domain.Membership;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterMembership implements RegisterMembershipUseCase {

    private final RegisterMembershipPort rport;

    private final MembershipMapper membershipMapper;
    @Override
    public void registerMembership(RegisterMembershipCommand command) {
        rport.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid())
        );
    }
}
