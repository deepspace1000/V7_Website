import { useQuery } from 'react-query';
import { UserRessourceService } from './generated';

export const useWhoamiQuery = () => {
  const { data } = useQuery({
    queryKey: ['whoami'],
    queryFn: () => UserRessourceService.getSelf(),
  });

  return data;
};
