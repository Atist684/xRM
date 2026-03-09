import { HttpInterceptorFn } from '@angular/common/http';

//TODO
export const authInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req);
};
