package screen.onboarding

import org.koin.dsl.module

internal val onboardingModule
    get() = module {
        factory {
            OnboardingViewModel(settings = get())
        }
    }
