package fr.projet2.monprojetmeteo.util.injection

import fr.projet2.monprojetmeteo.util.factory.ViewModelFactory

class Injection {

    companion object {
        fun provideViewModelFactory() : ViewModelFactory {
            return ViewModelFactory()
        }
    }

}