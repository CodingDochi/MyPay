package tutorial.membership.application.port.in;

import tutorial.common.UseCase;

@UseCase
public interface RegisterMembershipUseCase {
    void registerMembership(RegisterMembershipCommand command);
}
