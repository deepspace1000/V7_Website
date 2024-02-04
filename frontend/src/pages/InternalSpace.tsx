import { useWhoamiQuery } from '../state/api/user.ts';

export default function InternalSpace() {
  const whoami = useWhoamiQuery();
  return <div>{whoami?.user.email}</div>;
}
