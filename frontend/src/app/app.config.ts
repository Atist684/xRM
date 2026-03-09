import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';

import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { routes } from './app.routes';
import { authInterceptor } from './security/auth-interceptor';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
      provideHttpClient(
      withInterceptors([authInterceptor])
    ),
    // TODO: provideAppInitializer()
    // TODO: API config:
    /*
    {
      provide: Configuration,
      useFactory: (authService: AuthService) => {
        return new Configuration({
          withCredentials: true,
          credentials: {
            bearerAuth: authService.getToken.bind(authService),
          }
        });
      },
      deps: [AuthService]
    },
    */
  ]
};
