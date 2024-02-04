/* generated using openapi-typescript-codegen -- do no edit */
/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { CancelablePromise } from '../core/CancelablePromise';
import { OpenAPI } from '../core/OpenAPI';
import { request as __request } from '../core/request';
import type { LoginDto } from '../models/LoginDto';
import type { LoginResponseDto } from '../models/LoginResponseDto';
import type { WhoamiDto } from '../models/WhoamiDto';
export class UserRessourceService {
  /**
   * @param requestBody
   * @returns LoginResponseDto OK
   * @throws ApiError
   */
  public static login(requestBody: LoginDto): CancelablePromise<LoginResponseDto> {
    return __request(OpenAPI, {
      method: 'POST',
      url: '/user/login',
      body: requestBody,
      mediaType: 'application/json',
    });
  }
  /**
   * @returns WhoamiDto OK
   * @throws ApiError
   */
  public static getSelf(): CancelablePromise<WhoamiDto> {
    return __request(OpenAPI, {
      method: 'GET',
      url: '/user/whoami',
    });
  }
}
