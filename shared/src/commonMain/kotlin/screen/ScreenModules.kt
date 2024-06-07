package screen

import screen.detail.detailModule
import screen.onboarding.onboardingModule

val screenModules
    get() = listOf(
        detailModule,
        onboardingModule,
    )
